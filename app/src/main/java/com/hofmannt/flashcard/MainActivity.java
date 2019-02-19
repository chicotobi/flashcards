package com.hofmannt.flashcard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    String english[] = new String[5];
    String german[] = new String[5];
    Integer score[] = new Integer[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        english[0] = "house";
        english[1] = "car";
        english[2] = "book";
        english[3] = "to walk";
        english[4] = "red";

        german[0] = "Haus";
        german[1] = "Auto";
        german[2] = "Buch";
        german[3] = "gehen";
        german[4] = "rot";


        SharedPreferences sp = this.getSharedPreferences("DATA", Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        for(Integer i=0;i<5;i++) {
            e.putString("english"+i.toString(),english[i]);
            e.putString("german"+i.toString(),german[i]);
        }
        e.apply();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(this, Test.class);
        startActivity(intent);
    }
}
