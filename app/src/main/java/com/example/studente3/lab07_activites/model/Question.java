package com.example.studente3.lab07_activites.model;

/**
 * Created by student on 2016/4/12.
 */
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Question {
    @Element
    private String description;
    @Element
    private String optionA;
    @Element
    private String optionB;
    @Element
    private String optionC;

    public Question() {
    }

    public Question(String description, String optionA, String optionB, String optionC) {
        this.description = description;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
    }

    public String getDescription() {
        return description;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }
}
