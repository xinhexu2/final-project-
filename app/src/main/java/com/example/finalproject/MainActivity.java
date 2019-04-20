package com.example.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import unirest.HttpResponse;
import unirest.JsonNode;
import unirest.Unirest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpResponse<JsonNode> response = Unirest.get("http://data.fixer.io/api/latest")
                .queryString("access_key", "0c303d204d16a5cb605926b280feda14").asJson();
        Log.v("Debug", response.toString());


        EditText dollar = (EditText) findViewById(R.id.input);
        Double inputAmount = Double.valueOf(dollar.getText().toString());
//        Double JPYoutput = inputAmount * response;
//        Toast.makeText(getApplicationContext(), JPYoutput.toString(), Toast.LENGTH_LONG).show();


    }


}
