package com.Dudek9.currency;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpReqest extends AsyncTask<String,Void, Response> {

    OkHttpClient client = new OkHttpClient();
     String rate;
    static ProgressDialog dialog;

    @Override
    protected void onPreExecute() {

        dialog.setTitle("Pobieranie");
        dialog.setMessage("Trwa pobieranie...");
        dialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Response response) {
        dialog.cancel();
    }

    @Override
    protected Response doInBackground(String... strings) {
        synchronized (this) {
            String from = strings[0];
            String to = strings[1];
            try {
                Request request = new Request.Builder()
                        .url("https://currency-exchange.p.rapidapi.com/exchange?q=1.0&from=" + from + "&to=" + to)
                        .header("X-RapidAPI-Host", "currency-exchange.p.rapidapi.com")
                        .header("X-RapidAPI-Key", "71db54d3c2msh14f6d6f5ba46a8ep102e9ejsn10fdeec2e477")
                        .build();

                Response response = client.newCall(request).execute();
                // System.out.println(response.body().string());
                rate = response.body().string();
                Exchange.rate = rate;
                return response;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
