package com.hofmannt.flashcard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.MotionEvent;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Test extends AppCompatActivity {

    boolean isEnglish;
    Integer index;

    public void nextCard() {
        String prefix;
        if (isEnglish) {
            prefix = "english";
            isEnglish = false;
        } else {
            prefix = "german";
            isEnglish = true;
        }
        String text = sp.getString(prefix + index.toString(), "ERROR");

        TextView textView = findViewById(R.id.textView);
        textView.setText(text);
        if(isEnglish) {
            index++;
            if (index == 5) index = 0;
        }
    }

    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        sp = this.getSharedPreferences("DATA", Context.MODE_PRIVATE);
        index = 0;
        isEnglish = true;
        nextCard();
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
            nextCard();
        }
        return true;
    }
}
