package com.example.studente3.lab07_activites.service;

import com.example.studente3.lab07_activites.model.QuestionList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;
import retrofit2.http.GET;

/**
 * Created by student on 2016/4/20.
 */
public interface QuestionListService {
    @GET("/uc?export=download&id=0BwIdzAjvQ8FwWG5HZUxIZHJOd0k")
    Call<QuestionList> getQuestionList();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://drive.google.com/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build();
}
