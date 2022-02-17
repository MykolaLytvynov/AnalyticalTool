package ua.com.mykola.analyticaltool;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static ua.com.mykola.analyticaltool.Constants.DATE_FORMAT;

public class QuestionFormatter {


    public static Question makeQuestion(String dataQuestion) {

        String[] arrayDataQuestion = dataQuestion.split(" ");

        LocalDate date = null;
        try {
            date = LocalDate.parse(arrayDataQuestion[4], DATE_FORMAT);
        } catch (DateTimeParseException e) {
            System.out.println("Impossible date");
        }
        Question result = new Question(arrayDataQuestion[1],
                arrayDataQuestion[2],
                arrayDataQuestion[3],
                date,
                Integer.valueOf(arrayDataQuestion[5]));
        return result;
    }
}
