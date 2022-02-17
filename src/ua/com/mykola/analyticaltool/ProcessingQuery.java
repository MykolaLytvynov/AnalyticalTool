package ua.com.mykola.analyticaltool;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class ProcessingQuery {

    public String getAverageWaitingTime(List<Question> questions, Query query) {
        String result = "-";
        List<Question> relevantQuestionsByDate = getRelevantQuestionsByDate(questions, query);

        List<Question> relevantQuestionsByServiceAndQuestionType = getRelevantQuestionsByServiceAndQuestionType(relevantQuestionsByDate, query);

        if (relevantQuestionsByServiceAndQuestionType != null) {
            OptionalDouble averageWaitingTime = relevantQuestionsByServiceAndQuestionType.stream().mapToInt(q -> q.getTime()).average();
            if (!averageWaitingTime.isEmpty()) result = String.valueOf((int) averageWaitingTime.getAsDouble());
        }
        return result;
    }


    private List<Question> getRelevantQuestionsByDate(List<Question> questions, Query query) {
        List<Question> relevantQuestionsByDate = new ArrayList<>();

        for (Question question : questions) {
            if (query.getDateTo() == null) {
                if (!question.getDate().isBefore(query.getDateFrom())) {
                    relevantQuestionsByDate.add(question);
                }
            } else if (!question.getDate().isAfter(query.getDateTo()) &&
                    !question.getDate().isBefore(query.getDateFrom())) {
                relevantQuestionsByDate.add(question);
            }
        }
        return relevantQuestionsByDate;
    }


    private List<Question> getRelevantQuestionsByServiceAndQuestionType(List<Question> relevantQuestionsByDate, Query query) {
        List<Question> relevantQuestionsByServiceAndQuestionType = new ArrayList<>();
        for (Question question : relevantQuestionsByDate) {
            if (question.getService().startsWith(query.getService()) || query.getService().equals("*")) {
                if (question.getQuestionType().startsWith(query.getQuestionType()) || query.getQuestionType().equals("*")) {
                    relevantQuestionsByServiceAndQuestionType.add(question);
                }
            }
        }
        return relevantQuestionsByServiceAndQuestionType;
    }

}
