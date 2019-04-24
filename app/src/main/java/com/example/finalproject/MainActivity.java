package com.example.finalproject;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONObject;

import unirest.HttpResponse;
import unirest.JsonNode;
import unirest.Unirest;

public class MainActivity extends AppCompatActivity {
    private String value;
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
                        value = response;

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Debug", error.toString());

            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
    /**
     * @param json -input
     * @return -JPYoutput;
     */
    public static double getJPY(final java.lang.String json) {
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject rates = result.get("rates").getAsJsonObject();
        JsonElement jpy = rates.get("JPY");
        Double jpyrate = jpy.getAsDouble();
        return jpyrate;
    }
    /**
     * @param json -input
     * @return -USDoutput;
     */
    public static double getUSD(final java.lang.String json) {
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject rates = result.get("rates").getAsJsonObject();
        JsonElement usd = rates.get("USD");
        double usdrate = usd.getAsDouble();
        return usdrate;
    }
    public static double getGBP(final java.lang.String json) {
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject rates = result.get("rates").getAsJsonObject();
        JsonElement usd = rates.get("GBP");
        double gbprate = usd.getAsDouble();
        return gbprate;
    }
    public static double getCNY(final java.lang.String json) {
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject rates = result.get("rates").getAsJsonObject();
        JsonElement cny = rates.get("CNY");
        double cnyrate = cny.getAsDouble();
        return cnyrate;
    }
    public static double getKRW(final java.lang.String json) {
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject rates = result.get("rates").getAsJsonObject();
        JsonElement krw = rates.get("KRW");
        double krwrate = krw.getAsDouble();
        return krwrate;
    }
    void finishProcessView(final String value) {
        EditText dollar = (EditText) findViewById(R.id.input);
        Double inputAmount = Double.valueOf(dollar.getText().toString());
        Double jpyOutput = inputAmount * getUSD(value) / getJPY(value);
        String jpyString = String.valueOf(jpyOutput);
        //Toast JPYToast = Toast.makeText(getApplicationContext(), jpyString, Toast.LENGTH_LONG);
        //JPYToast.show();
        //JPYToast.setGravity(0,0,0);
        TextView jpyView = (TextView) findViewById(R.id.JPYoutput);
        jpyView.setText(jpyString);
    }

}
