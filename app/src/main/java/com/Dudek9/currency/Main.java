package com.Dudek9.currency;

import android.annotation.SuppressLint;
import android.os.Bundle;
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

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));


        listView=findViewById(R.id.lista);
        editText1=findViewById(R.id.editText2);
        editText2=findViewById(R.id.editText);

//SGD\,\MYR\,\EUR\,\USD\,\AUD\,\JPY\,\CNH\,\HKD\,\CAD\,\INR\,\DKK\,\GBP\,\RUB\,\NZD\,\MXN\,\IDR\,\TWD\,\THB\,\VND\]
        final ArrayList<String> array=new ArrayList<>();
        array.add("PLN");
        array.add("GBP");
        array.add("EUR");
        array.add("USD");

        //ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,array);
        Logo adapter=new Logo(array,this);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(editText2.isFocused()){
                    editText2.setText(array.get(position));
                }else {
                    editText1.setText(array.get(position));
                }
            }
        });


    }


    @Override
    public void onBackPressed() {

    }
}




