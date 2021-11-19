package com.example.a19113013_st088_pamuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAbout = findViewById(R.id.btnabout);
        btnAbout.setOnClickListener(this);

        Button btndirectory = findViewById(R.id.btndirectory);
        btndirectory.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Class<?> tClass = null;
        if (view.getId() == R.id.btndirectory)
            tClass = ActivityDirectory.class;
        else if (view.getId() == R.id.btnabout)
            tClass = About.class;

        Intent intent = new Intent(this, tClass);
        startActivity(intent);

    }

}



//        Button btndirectory = findViewById(R.id.btndirectory);
//        btndirectory.setOnClickListener(view ->{
//            Intent intent = new Intent(MainActivity.this, ActivityDirectory.class);
//            startActivity(intent);
//        });

//        Button btnabout = findViewById(R.id.btnabout);
//        btnabout.setOnClickListener(new View.OnClickListener(){
//            public void onClick(View view){
//                Intent intent = new Intent(MainActivity.this, About.class);
//                startActivity(intent);
//            }
//        });

//        Button btnabout = findViewById(R.id.btnabout);
//        btnabout.setOnClickListener(this);