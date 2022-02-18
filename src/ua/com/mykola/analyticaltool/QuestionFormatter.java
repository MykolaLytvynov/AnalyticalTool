package ua.com.mykola.analyticaltool;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static ua.com.mykola.analyticaltool.Constants.DATE_FORMAT;

public class QuestionFormatter {


    public static Question makeQuestion(String dataQuestion) {
        checkDataQuestionValidate(dataQuestion);

        String[] arrayDataQuestion = dataQuestion.split(" ");

        Question result = new Question(arrayDataQuestion[1],
                arrayDataQuestion[2],
                arrayDataQuestion[3],
                getLocalDate(arrayDataQuestion[4]),
                Integer.valueOf(arrayDataQuestion[5]));

        return result;
    }


    private static void checkDataQuestionValidate(String dataQuestion){
        String[] arrayDataQuestion = dataQuestion.split(" ");
        if (arrayDataQuestion.length != 6) {
            throw new IllegalArgumentException("Data question is not valid - " + dataQuestion);
        }
    }


    private static LocalDate getLocalDate (String date) {
        LocalDate result = null;
        try {
            result = LocalDate.parse(date, DATE_FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Impossible date - " + date);
        }
        return result;
    }
}
