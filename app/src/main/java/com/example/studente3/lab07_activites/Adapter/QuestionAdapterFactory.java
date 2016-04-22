package com.example.studente3.lab07_activites.Adapter;


import android.content.res.Resources;
import android.util.Log;

import com.example.studente3.lab07_activites.MyApp.MyApp;
import com.example.studente3.lab07_activites.model.Question;
import com.example.studente3.lab07_activites.model.QuestionList;
import com.example.studente3.lab07_activites.service.QuestionListService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by student on 2016/4/12.
 */
public class QuestionAdapterFactory {
    private static QuestionAdapter adapter;

    public static QuestionAdapter getQuestionAdapter() {
        if (adapter == null) {
            Resources res = MyApp.getContext().getResources();
            //adapter = new QuestionFromString(res);
            try {
                adapter = new QuestionFromXml(res);
            }catch (Exception e){
                Log.d("factory",e.toString());
            }

        }
        return adapter;
    }


    public static void getQuestionAdapter(Receiver receiver){
        loadFromGoogleDrive(receiver);
    }

    private static void loadFromGoogleDrive(final Receiver receiver) {
        QuestionListService service = QuestionListService.retrofit.create(QuestionListService.class);
        Call<QuestionList> call = service.getQuestionList();
        call.enqueue(new Callback<QuestionList>() {
            @Override
            public void onResponse(Call<QuestionList> call, Response<QuestionList> response) {
                if (response.isSuccessful()){
                    Log.d("Retrofit","onResponse success");
                    QuestionList q1 = response.body();
                    List<Question> list = q1.getList();
                    adapter = new QuestionFromGoogleDriveXml(list);
                    receiver.receiveQuestionAdapter(adapter);
                }else{
                    Log.d("Retrofit","onResponse fail");
                }
            }

            @Override
            public void onFailure(Call<QuestionList> call, Throwable t) {
                Log.d("Retrofit","onResponse fail"+t.toString());
            }
        });
    }

    private QuestionAdapterFactory() {

    }

    public interface Receiver {
        void receiveQuestionAdapter(QuestionAdapter adapter);
    }
}
