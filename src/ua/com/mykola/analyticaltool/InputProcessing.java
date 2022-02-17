package ua.com.mykola.analyticaltool;

import java.util.ArrayList;
import java.util.List;

public class InputProcessing {
    private ProcessingQuery processingQuery = new ProcessingQuery();

    public List<String> getOutputOfAllAverageWaitTimes(List<String> input) {
        List<Question> allQuestions = new ArrayList<>();
        List<String> queryResult = new ArrayList<>();

        for (String line : input) {
            if (line.startsWith("C")) {
                allQuestions.add(QuestionFormatter.makeQuestion(line));
            }
            if (line.startsWith("D")) {
                queryResult.add(processingQuery.getAverageWaitingTime(allQuestions, QueryFormatter.makeQuery(line)));
            }
        }
        return queryResult;
    }


}
