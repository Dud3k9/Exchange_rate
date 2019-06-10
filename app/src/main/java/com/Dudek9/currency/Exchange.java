package com.Dudek9.currency;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import kotlin.jvm.Synchronized;

public class Exchange extends AppCompatActivity {

    TextView textView;
    TextView textView2;
    static String rate;
    EditText editText;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));

        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        editText=findViewById(R.id.editText);
        textView3=findViewById(R.id.textView3);

        Intent intent = getIntent();
        String from = intent.getStringExtra("z");
        String to = intent.getStringExtra("na");
        textView.setText(from + "  ->  " + to);

        textView2.setText(rate);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(editText.getText().toString().equals("")||editText.getText().toString()==null) {
                    textView3.setText("0.0");
                }   else{
                    System.out.println(editText.getText());
                    Double wpisany = Double.parseDouble(editText.getText().toString());
                    Double rateD = Double.parseDouble(rate);
                    textView3.setText("" + wpisany * rateD);
                }
            }
        });
    }



}
