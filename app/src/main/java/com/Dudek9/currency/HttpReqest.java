package com.Dudek9.currency;

import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpReqest extends AsyncTask<String,Void, Response> {

    OkHttpClient client = new OkHttpClient();
    static String rate;

    public static String getRate(String from,String to){
        new HttpReqest().execute(from,to);
        return rate;
    }

    @Override
    protected void onPostExecute(Response response) {
        try {
            rate=response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Response doInBackground(String... strings) {
        String from=strings[0];
        String to=strings[1];
        try {
            Request request = new Request.Builder()
                    .url("https://currency-exchange.p.rapidapi.com/exchange?q=1.0&from="+from+"&to="+to)
                    .header("X-RapidAPI-Host", "currency-exchange.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "71db54d3c2msh14f6d6f5ba46a8ep102e9ejsn10fdeec2e477")
                    .build();

            Response response = client.newCall(request).execute();
            return response;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
