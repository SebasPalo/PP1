package com.sebaspalo.conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ePesos, eDolares;
    Button bConvertir;
    Double pesos, dolares;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ePesos = (EditText) findViewById(R.id.pesos);
        eDolares = (EditText) findViewById(R.id.dolares);
        bConvertir = (Button) findViewById(R.id.Convertir);

        bConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!ePesos.getText().toString().equals("") && eDolares.getText().toString().equals("")) {
                    pesos = Double.parseDouble(ePesos.getText().toString());
                    dolares = pesos / 3000;
                    eDolares.setText(dolares.toString());

                } else if (ePesos.getText().toString().equals("") && !eDolares.getText().toString().equals("")) {
                    dolares = Double.parseDouble(eDolares.getText().toString());
                    pesos = dolares * 3000;
                    ePesos.setText(pesos.toString());

                }
                else if (ePesos.getText().toString().equals("") && eDolares.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Digite cantidad a convertir",Toast.LENGTH_LONG).show();

                }
                else {
                    ePesos.setText("");
                    eDolares.setText("");
                    Toast.makeText(getApplicationContext(),"Debe haber un campo vacio para realizar la conversión",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
