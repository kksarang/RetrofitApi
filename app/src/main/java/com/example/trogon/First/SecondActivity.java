package com.example.trogon.First;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.trogon.R;
import com.example.trogon.second.Cast;

public class SecondActivity extends AppCompatActivity {

    Button more;
    TextView namePass,languagePass,typePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        namePass=findViewById(R.id.movienamepass);
        languagePass=findViewById(R.id.languagepass);
        typePass=findViewById(R.id.typepass);

        more=findViewById(R.id.button);

        namePass.setText(getIntent().getStringExtra("name1"));

        languagePass.setText(getIntent().getStringExtra("language1"));

        typePass.setText(getIntent().getStringExtra("type1"));


        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SecondActivity.this, Cast.class);
                startActivity(intent);

            }
        });


    }
}