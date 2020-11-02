package com.example.sonaraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class all_complaints_panel extends AppCompatActivity {
ListView all_compaints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_complaints_panel);
        all_compaints = findViewById(R.id.all_complaints_ll);

        

    }
}