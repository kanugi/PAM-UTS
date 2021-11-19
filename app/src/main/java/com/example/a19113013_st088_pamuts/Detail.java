package com.example.a19113013_st088_pamuts;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);
        TextView title = findViewById(R.id.list_title);
        TextView overview = findViewById(R.id.list_desc);
        TextView release_date = findViewById(R.id.list_release);

    }
}
