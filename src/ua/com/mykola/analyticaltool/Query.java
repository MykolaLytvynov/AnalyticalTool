package ua.com.mykola.analyticaltool;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Query {
    // for example: 9.1 or 9 or '*'
    private String service;
    // for example: 7.14.4 or 7 or '*'
    private String questionType;
    // response type ‘P’ (first answer) or ‘N’ (next answer).
    private String responseType;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public Query(String service, String questionType, String responseType, LocalDate dateFrom, LocalDate dateTo) {
        this.service = service;
        this.questionType = questionType;
        this.responseType = responseType;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public String toString() {
        return "Query{" +
                "service='" + service + '\'' +
                ", questionType='" + questionType + '\'' +
                ", responseType='" + responseType + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
