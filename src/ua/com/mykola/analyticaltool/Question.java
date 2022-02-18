package ua.com.mykola.analyticaltool;

import java.time.LocalDate;

public class Question {
    // for example: 9.1 or only 9
    private String service;
    // for example: 7.14.4 or only 7
    private String questionType;
    // response type ‘P’ (first answer) or ‘N’ (next answer).
    private String responseType;
    private LocalDate date;
    private Integer time;

    public Question(String service, String questionType, String responseType, LocalDate date, Integer time) {
        this.service = service;
        this.questionType = questionType;
        this.responseType = responseType;
        this.date = date;
        this.time = time;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Question{" +
                "service='" + service + '\'' +
                ", questionType='" + questionType + '\'' +
                ", responseType='" + responseType + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
