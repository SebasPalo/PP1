package com.sebaspalo.notas;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText eN1,eN2,eN3,eN4,eN5;
    Button bCalcular;
    TextView tNotafinal;
    Double n1,n2,n3,n4,n5,nfinal;
    String aux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eN1=(EditText)findViewById(R.id.eN1);
        eN2=(EditText)findViewById(R.id.eN2);
        eN3=(EditText)findViewById(R.id.eN3);
        eN4=(EditText)findViewById(R.id.eN4);
        eN5=(EditText)findViewById(R.id.eN5);
        bCalcular=(Button)findViewById(R.id.bCalcular);
        tNotafinal=(TextView) findViewById(R.id.tNotafinal);


        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                if (!eN1.getText().toString().equals("") && !eN1.getText().toString().startsWith(".")){n1=Double.parseDouble(eN1.getText().toString());}
                else {n1=0.0; eN1.setText("0.0");}
                if (!eN2.getText().toString().equals("")&& !eN2.getText().toString().startsWith(".")){n2=Double.parseDouble(eN2.getText().toString());}
                else {n2=0.0;eN2.setText("0.0");}
                if (!eN3.getText().toString().equals("")&& !eN3.getText().toString().startsWith(".")){n3=Double.parseDouble(eN3.getText().toString());}
                else {n3=0.0;eN3.setText("0.0");}
                if (!eN4.getText().toString().equals("")&& !eN4.getText().toString().startsWith(".")){n4=Double.parseDouble(eN4.getText().toString());}
                else {n4=0.0;eN4.setText("0.0");}
                if (!eN5.getText().toString().equals("")&& !eN5.getText().toString().startsWith(".")){n5=Double.parseDouble(eN5.getText().toString());}
                else {n5=0.0;eN5.setText("0.0");}

                if (n1>5 || n2>5 || n3>5 || n4>5 || n5>5){

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Dear Smart Student");
                    alertDialog.setMessage("Only numbers from 0 to 5 are allowed");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                }
                else {nfinal=((n1*0.6)+(n2*0.05)+(n3*0.07)+(n4*0.08)+(n5*0.2));
                    aux= nfinal.toString();
                    //aux= String.format("%.2f", aux);
                    tNotafinal.setText(aux);

                    if (nfinal>=0 && nfinal<=1.04)Toast.makeText(getApplicationContext(),"Estas en el lugar equivocado",Toast.LENGTH_LONG).show();
                    else if (nfinal>=1.05&& nfinal<=2.04)Toast.makeText(getApplicationContext(),"Remal",Toast.LENGTH_LONG).show();
                    else if (nfinal>=2.05&& nfinal<=3.04)Toast.makeText(getApplicationContext(),"Es posible recuperarse",Toast.LENGTH_LONG).show();
                    else if (nfinal>=3.05&& nfinal<=4.04)Toast.makeText(getApplicationContext(),"Normalito",Toast.LENGTH_LONG).show();
                    else if (nfinal>4.05&& nfinal<=4.54)Toast.makeText(getApplicationContext(),"Muy Bien",Toast.LENGTH_LONG).show();
                    else Toast.makeText(getApplicationContext(),"Excelente estudiante",Toast.LENGTH_LONG).show();

                }
            }
        });
    }


}




