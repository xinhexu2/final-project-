package com.example.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;


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
        findViewById(R.id.button).setOnClickListener(v -> finishProcessView());
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
    public static double getHKD(final java.lang.String json) {
        JsonParser parser = new JsonParser();
        JsonObject result = parser.parse(json).getAsJsonObject();
        JsonObject rates = result.get("rates").getAsJsonObject();
        JsonElement hkd = rates.get("HKD");
        double hkdrate = hkd.getAsDouble();
        return hkdrate;
    }
    public void finishProcessView() {
        EditText dollar = (EditText) findViewById(R.id.input);
        Double inputAmount = Double.valueOf(dollar.getText().toString());
        Double jpyOutput = inputAmount * getJPY(value) / getUSD(value);
        String jpyString = String.valueOf(jpyOutput);
        TextView jpyView = (TextView) findViewById(R.id.JPYoutput);
        jpyView.setText(jpyString);
        Double gbpOutput = inputAmount * getGBP(value) / getUSD(value);
        String gbpString = String.valueOf(gbpOutput);
        TextView gbpView = (TextView) findViewById(R.id.gbpoutput);
        gbpView.setText(gbpString);
        Double cnyOutput = inputAmount * getCNY(value) / getUSD(value);
        String cnyString = String.valueOf(cnyOutput);
        TextView cnyView = (TextView) findViewById(R.id.cnyoutput);
        cnyView.setText(cnyString);
        Double krwOutput = inputAmount * getKRW(value) / getUSD(value);
        String krwString = String.valueOf(krwOutput);
        TextView krwView = (TextView) findViewById(R.id.krwoutput);
        krwView.setText(krwString);
        Double hkdOutput = inputAmount * getHKD(value) / getUSD(value);
        String hkdString = String.valueOf(hkdOutput);
        TextView hkdView = (TextView) findViewById(R.id.hkdoutput);
        hkdView.setText(hkdString);
    }
}
