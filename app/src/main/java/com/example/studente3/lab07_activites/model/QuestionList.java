package com.example.studente3.lab07_activites.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by student on 2016/4/20.
 */
@Root
public class QuestionList {
    @ElementList
    private List<Question> list;

    public List<Question> getList() {
        return list;
    }
}
