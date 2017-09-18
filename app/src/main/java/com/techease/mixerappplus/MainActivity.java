package com.techease.mixerappplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText enterUrl;
    Button go;
    String ssl = " http://";
    String url ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go = (Button)findViewById(R.id.Go);
        go.setEnabled(false);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        enterUrl = (EditText)findViewById(R.id.enterUrl);


        enterUrl.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                go.setEnabled(true);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                go.setEnabled(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

                go.setEnabled(true);
            }
        });



            go.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    url =  enterUrl.getText().toString();
                    String fin = ssl.concat(url);
                    Intent intent = new Intent(MainActivity.this, Webview.class);
                    intent.putExtra("url", fin);
                    startActivity(intent);


                }
            });





        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("http://");
        categories.add("https://");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();
        ssl = item ;
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    }

