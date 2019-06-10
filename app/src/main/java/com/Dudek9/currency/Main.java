package com.Dudek9.currency;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Main extends AppCompatActivity {


    ListView listView;
    EditText editText1;
    EditText editText2;
    static Intent intent;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));


        listView = findViewById(R.id.lista);
        editText1 = findViewById(R.id.editText2);
        editText2 = findViewById(R.id.editText);

//SGD\,\MYR\,\EUR\,\USD\,\AUD\,\JPY\,\CNH\,\HKD\,\CAD\,\INR\,\DKK\,\GBP\,\RUB\,\NZD\,\MXN\,\IDR\,\TWD\,\THB\,\VND\]
        final ArrayList<String> array = new ArrayList<>();
        array.add("PLN");
        array.add("GBP");
        array.add("EUR");
        array.add("USD");
        array.add("SGD");
        array.add("MYR");
        array.add("AUD");
        array.add("JPY");
        array.add("CNH");
        array.add("HKD");
        array.add("CAD");
        array.add("INR");
        array.add("DKK");
        array.add("RUB");
        array.add("NZD");
        array.add("MXN");
        array.add("IDR");
        array.add("TWD");
        array.add("THB");
        array.add("VND");

        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        MainAdapter adapter = new MainAdapter(array, this);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (editText2.isFocused()) {
                    editText2.setText(array.get(position));
                } else {
                    editText1.setText(array.get(position));
                }
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab2);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(Main.this, Exchange.class);
                intent.putExtra("z", editText1.getText().toString());
                intent.putExtra("na", editText2.getText().toString());

                HttpReqest.dialog = new ProgressDialog(Main.this);
                HttpReqest httpReqest = new HttpReqest();
                httpReqest.execute(editText1.getText().toString(), editText2.getText().toString());

                myListener();

            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

    public void myListener(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    while (HttpReqest.dialog.isShowing()) {
                    }
                    startActivity(intent);
                }

            }

        }).start();
    }



    @Override
    public void onBackPressed() {

    }
}




