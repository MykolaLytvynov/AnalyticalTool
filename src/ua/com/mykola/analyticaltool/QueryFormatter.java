package ua.com.mykola.analyticaltool;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static ua.com.mykola.analyticaltool.Constants.DATE_FORMAT;

public class QueryFormatter {

    public static Query makeQuery(String dataQuery) {
        checkDataQueryValidate(dataQuery);

        String[] arrayDataQuery = dataQuery.split(" ");

        String[] twoDates = arrayDataQuery[4].split("-");
        LocalDate dateTo = null;
        if (twoDates.length != 1) dateTo = getLocalDate(twoDates[1]);

        Query result = new Query(arrayDataQuery[1],
                arrayDataQuery[2],
                arrayDataQuery[3],
                getLocalDate(twoDates[0]),
                dateTo);

        return result;
    }


    private static void checkDataQueryValidate(String dataQuery) {
        String[] arrayDataQuery = dataQuery.split(" ");
        if (arrayDataQuery.length != 5) {
            throw new IllegalArgumentException("Data query is not valid - " + dataQuery);
        }
    }


    private static LocalDate getLocalDate(String date) {
        LocalDate result = null;
        try {
            result = LocalDate.parse(date, DATE_FORMAT);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Impossible date - " + date);
        }
        return result;
    }
}
