package ua.com.mykola.analyticaltool;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static ua.com.mykola.analyticaltool.Constants.DATE_FORMAT;

public class QueryFormatter {

    public static Query makeQuery(String dataQuery) {
        String[] arrayDataQuery = dataQuery.split(" ");
        LocalDate dateFrom = null;
        LocalDate dateTo = null;

        String[] twoDates = arrayDataQuery[4].split("-");
        try {
            dateFrom = LocalDate.parse(twoDates[0], DATE_FORMAT);
            if (twoDates.length != 1) dateTo = LocalDate.parse(twoDates[1], DATE_FORMAT);
        } catch (DateTimeParseException e) {
            System.out.println("Impossible date");
        }

        Query result = new Query(arrayDataQuery[1],
                arrayDataQuery[2],
                arrayDataQuery[3],
                dateFrom, dateTo);

        return result;
    }
}
