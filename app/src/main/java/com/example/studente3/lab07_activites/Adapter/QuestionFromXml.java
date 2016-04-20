package com.example.studente3.lab07_activites.Adapter;

import android.content.res.Resources;

import com.example.studente3.lab07_activites.R;
import com.example.studente3.lab07_activites.model.Question;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by student on 2016/4/18.
 */
public class QuestionFromXml implements QuestionAdapter{
    private List<Question> list = new ArrayList<>();

    public QuestionFromXml(Resources res) throws IOException,XmlPullParserException{
        InputStream is = res.openRawResource(R.raw.questions);
        list = parse(is);

    }

    private List<Question> parse(InputStream is) throws IOException,XmlPullParserException{
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput(is, "UTF-8");
        xpp.nextTag();
        xpp.require(XmlPullParser.START_TAG,null,"Exams");
        while (xpp.nextTag() == XmlPullParser.START_TAG){
            xpp.require(XmlPullParser.START_TAG, null, "Exam");
            xpp.nextTag();
            xpp.require(XmlPullParser.START_TAG, null, "Question");
            String question = xpp.nextText();
            xpp.require(XmlPullParser.END_TAG, null, "Question");
            xpp.nextTag();
            xpp.require(XmlPullParser.START_TAG, null, "OptionA");
            String optionA = xpp.nextText();
            xpp.require(XmlPullParser.END_TAG, null, "OptionA");
            xpp.nextTag();
            xpp.require(XmlPullParser.START_TAG, null, "OptionB");
            String optionB = xpp.nextText();
            xpp.require(XmlPullParser.END_TAG, null, "OptionB");
            xpp.nextTag();
            xpp.require(XmlPullParser.START_TAG, null, "OptionC");
            String optionC = xpp.nextText();
            xpp.require(XmlPullParser.END_TAG, null, "OptionC");
            xpp.nextTag();
            xpp.require(XmlPullParser.END_TAG, null, "Exam");
            list.add(new Question(question,optionA,optionB,optionC));

        }
        xpp.require(XmlPullParser.END_TAG,null,"Exams");
        return list;
    }

    @Override
    public int getQuestionCount() {
        return list.size();
    }

    @Override
    public CharSequence getQuestion(int index) {
        return list.get(index).getDescription();
    }

    @Override
    public CharSequence getQuestionOptionA(int index) {
        return list.get(index).getOptionA();
    }

    @Override
    public CharSequence getQuestionOptionB(int index) {
        return list.get(index).getOptionB();
    }

    @Override
    public CharSequence getQuestionOptionC(int index) {
        return list.get(index).getOptionC();
    }
}
