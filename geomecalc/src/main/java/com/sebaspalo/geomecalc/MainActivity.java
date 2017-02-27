package com.sebaspalo.geomecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    EditText eParam1, eLado2,eBase,eAltura;
    TextView tPeri, tVolumen, tArea;
    ImageView iFigura;
    Button bCalcular;
    RadioGroup RGroup;
    int flag;
    double perimetro,area,volumen,aux;
    String auxString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eParam1=(EditText) findViewById(R.id.eParam1);
        eLado2=(EditText) findViewById(R.id.eLado2);
        eBase=(EditText) findViewById(R.id.eBase);
        eAltura=(EditText) findViewById(R.id.eAltura);
        tPeri=(TextView) findViewById(R.id.tPeri);
        tVolumen=(TextView) findViewById(R.id.tVolumen);
        tArea=(TextView) findViewById(R.id.tArea);
        iFigura=(ImageView) findViewById(R.id.iFigura);
        bCalcular=(Button) findViewById(R.id.bCalcular);
        RGroup =(RadioGroup) findViewById(R.id.RGroup);



       bCalcular.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if (flag==0){
                   Toast.makeText(MainActivity.this, "Seleccione figura", Toast.LENGTH_SHORT).show();}
               else if (flag==1){
                   if (!eParam1.getText().toString().equals("")&& !eParam1.getText().toString().equals(".")){
                       aux=Double.parseDouble(eParam1.getText().toString());
                       perimetro=aux*4;
                       area=aux*aux;
                       tArea.setText(String.valueOf(area));
                       tPeri.setText(String.valueOf(perimetro));
                   }
                   else Toast.makeText(MainActivity.this, "Ingrese Valores", Toast.LENGTH_SHORT).show();

               }
               else if (flag==2){
                   if (!eParam1.getText().toString().equals("") && !eParam1.getText().toString().equals(".")){
                       aux=Double.parseDouble(eParam1.getText().toString());
                       perimetro=aux*2*3.1415;
                       area=(aux*aux)*3.1415;
                       tArea.setText(String.valueOf(area));
                       tPeri.setText(String.valueOf(perimetro));
                   }
                   else Toast.makeText(MainActivity.this, "Ingrese Valores", Toast.LENGTH_SHORT).show();
               }
               else if (flag==3){
                   if (!eParam1.getText().toString().equals("") && !eParam1.getText().toString().equals(".") && !eLado2.getText().toString().equals("")&& !eLado2.getText().toString().equals(".")&& !eBase.getText().toString().equals("")&& !eBase.getText().toString().equals(".")&& !eAltura.getText().toString().equals("")&& !eAltura.getText().toString().equals(".") ){
                       perimetro=Double.parseDouble(eParam1.getText().toString())+Double.parseDouble(eLado2.getText().toString())+Double.parseDouble(eBase.getText().toString());
                       area=(Double.parseDouble(eBase.getText().toString())*Double.parseDouble(eAltura.getText().toString()))/2;
                       tArea.setText(String.valueOf(area));
                       tPeri.setText(String.valueOf(perimetro));
                   }
                   else Toast.makeText(MainActivity.this, "Ingrese Valores", Toast.LENGTH_SHORT).show();
               }
               else if (flag==4){
                   if (!eParam1.getText().toString().equals("") && !eParam1.getText().toString().equals(".")) {
                       aux=Double.parseDouble(eParam1.getText().toString());
                       perimetro=aux*12;
                       area=(aux*aux)*6;
                       volumen=aux*aux*aux;
                       tArea.setText(String.valueOf(area));
                       tPeri.setText(String.valueOf(perimetro));
                       tVolumen.setText(String.valueOf(volumen));
                   }
                   else Toast.makeText(MainActivity.this, "Ingrese Valores", Toast.LENGTH_SHORT).show();
               }


           }
       });

    }

    public void clickradio(View view){

        boolean checked =((RadioButton) view).isChecked();
        int id=view.getId();

        eParam1.setVisibility(View.INVISIBLE);
        eLado2.setVisibility(View.INVISIBLE);
        eBase.setVisibility(View.INVISIBLE);
        eAltura.setVisibility(View.INVISIBLE);

        switch (id){
            case R.id.RBcuadro:
                if (checked){
                    iFigura.setImageResource(R.drawable.cuadrado);
                    eParam1.setVisibility(View.VISIBLE);
                    eParam1.setHint("Lado");
                    eParam1.setText("");
                    tVolumen.setText("NA");
                    tPeri.setText("0.0");
                    tArea.setText("0.0");
                    flag=1;
                }break;
            case R.id.RBcirculo:
                if(checked){
                    iFigura.setImageResource(R.drawable.circulo);
                    eParam1.setVisibility(View.VISIBLE);
                    eParam1.setHint("Radio");
                    eParam1.setText("");
                    tVolumen.setText("NA");
                    tPeri.setText("0.0");
                    tArea.setText("0.0");
                    flag=2;
                }break;
            case R.id.RBtriangulo:
                if(checked){
                    iFigura.setImageResource(R.drawable.triangulo);
                    eParam1.setVisibility(View.VISIBLE);
                    eLado2.setVisibility(View.VISIBLE);
                    eBase.setVisibility(View.VISIBLE);
                    eAltura.setVisibility(View.VISIBLE);
                    eParam1.setText("");
                    eLado2.setText("");
                    eBase.setText("");
                    eAltura.setText("");
                    eParam1.setHint("Lado 1");
                    tVolumen.setText("NA");
                    tPeri.setText("0.0");
                    tArea.setText("0.0");
                    flag=3;
                }break;
            case R.id.RBcubo:
                if(checked){
                    iFigura.setImageResource(R.drawable.cubo);
                    eParam1.setVisibility(View.VISIBLE);
                    eParam1.setHint("l - Lado");
                    eParam1.setText("");
                    tVolumen.setText("0.0");
                    tPeri.setText("0.0");
                    tArea.setText("0.0");
                    flag=4;
                }break;
        }
    }





}
