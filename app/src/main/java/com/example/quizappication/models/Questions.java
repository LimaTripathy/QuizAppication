package com.example.quizappication.models;

import java.util.List;

public class Questions {
    private String question;
    private List<String> choices;
    private String answer;


    @Override
    public String toString() {
        return "Questions{" + "question='" + question + '\'' + ", answers=" + answer + ", choice=" + choices + '}';
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getChoices() {
        return choices;
    }

    public void setChoices(List<String> choices) {
        this.choices = choices;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
