package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public Button toForm;
    public Button toPage;
    public String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toForm = findViewById(R.id.toForm);
        toForm.setOnClickListener(this);
        toPage = findViewById(R.id.toPage);
        toPage.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toForm:
                Intent intentForm = new Intent(view.getContext(), FormActivity.class);
                startActivityForResult(intentForm, 1);
                break;
            case R.id.toPage:
                Uri url = Uri.parse(link);
                Intent intentLink = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
                startActivity(intentLink);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        Bundle arg = data.getExtras();
        if (arg != null) {
            link = arg.get("link").toString();
            if (link.equals("")) {
                link = "Enter your link again";
            }
            else {
                toPage = findViewById(R.id.toPage);
                toPage.setVisibility(View.VISIBLE);
            }
            Toast.makeText(getApplication(), "Enter link: " + link, Toast.LENGTH_LONG).show();
        }
    }
}