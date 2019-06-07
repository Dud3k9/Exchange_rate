package com.Dudek9.currency;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    new Async().execute();


    }


    class Async extends AsyncTask<Void,Void,Response>{
        @Override
        protected void onPostExecute(Response s) {
            try {
                System.out.println(s.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected Response doInBackground(Void... voids) {
            Response response=null;
            try {
                response= doGetRequest();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }
    }

    OkHttpClient client = new OkHttpClient();
    Response doGetRequest() throws IOException {
        Request request = new Request.Builder()
                .url("https://currency-exchange.p.rapidapi.com/exchange?q=1.0&from=SGD&to=MYR")
                .header("X-RapidAPI-Host", "currency-exchange.p.rapidapi.com")
                .header("X-RapidAPI-Key", "71db54d3c2msh14f6d6f5ba46a8ep102e9ejsn10fdeec2e477")
                .build();

        Response response = client.newCall(request).execute();
        return response;
    }
}
