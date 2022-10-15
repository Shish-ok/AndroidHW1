package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormActivity extends AppCompatActivity {

    public Button setLink;
    public EditText linkForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        setLink = findViewById(R.id.setLink);
        setLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linkForm = findViewById(R.id.link);
                String link = linkForm.getText().toString();
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("link", link);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}