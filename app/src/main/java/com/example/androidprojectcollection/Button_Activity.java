package com.example.androidprojectcollection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class Button_Activity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5;
    ConstraintLayout parent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2);

        parent = findViewById(R.id.parent);

        btn1 = (Button) findViewById(R.id.BtnActivity1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Button_Activity.this, Activity1.class);
                startActivity(intent1);
            }
        });

        btn2 = (Button) findViewById(R.id.BtnActivity2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Button_Activity.this, "Hello World!", Toast.LENGTH_SHORT).show();
            }
        });

        btn3 = (Button) findViewById(R.id.BtnActivity3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn3.setAlpha(0);
            }
        });


        btn4 = (Button) findViewById(R.id.BtnActivity4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int il = r.nextInt(4);
                switch (il) {
                    case 1:
                        btn4.setBackgroundColor(Color.GREEN);
                        break;
                    case 2:
                        btn4.setBackgroundColor(Color.RED);
                        break;
                    case 3:
                        btn4.setBackgroundColor(Color.YELLOW);
                        break;
                }
            }
        });

        btn5 = (Button) findViewById(R.id.BtnActivity5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                int il = r.nextInt(4);
                switch (il) {
                    case 1:
                        parent.setBackgroundResource(R.color.purple_500);
                        break;
                    case 2:
                        parent.setBackgroundResource(R.color.purple_200);
                        break;
                    case 3:
                        parent.setBackgroundResource(R.color.purple_700);
                        break;
                }
            }
        });
    }
}