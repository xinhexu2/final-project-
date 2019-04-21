package com.example.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import unirest.HttpResponse;
import unirest.JsonNode;
import unirest.Unirest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://data.fixer.io/api/latest?access_key=0c303d204d16a5cb605926b280feda14";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d("Debug", response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Debug", error.toString());

            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);


//        EditText dollar = (EditText) findViewById(R.id.input);
//        Double inputAmount = Double.valueOf(dollar.getText().toString());
//        Double JPYoutput = inputAmount * response;
//        Toast.makeText(getApplicationContext(), JPYoutput.toString(), Toast.LENGTH_LONG).show();


    }


}
