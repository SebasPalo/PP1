package com.sebaspalo.resistorcalcu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.Math;

import static com.sebaspalo.resistorcalcu.R.color.black;
import static com.sebaspalo.resistorcalcu.R.color.gray;
import static com.sebaspalo.resistorcalcu.R.color.white;
import static com.sebaspalo.resistorcalcu.R.drawable.cafe;
import static com.sebaspalo.resistorcalcu.R.drawable.datass;
import static com.sebaspalo.resistorcalcu.R.drawable.negro;

public class MainActivity extends AppCompatActivity {

    TextView tValor,tTolerancia,tTemp;
    Button b1,b2,b3,b4,b5,b6;
    RadioGroup RGroup;
    int tolerancia,temp,flag,flagb1,flagb2,flagb3,flagb3aux,flagaux,flagaux2,flagb4,flagb4aux,flagb5,flagb6;
    double v1,v2,v3,v4;
    int color[]={R.drawable.negro, R.drawable.cafe, R.drawable.rojo, R.drawable.naranja, R.drawable.amarillo,R.drawable.verde, R.drawable.azul, R.drawable.purpura, R.drawable.gray, R.drawable.blanco, R.drawable.dorado, R.drawable.plateado};
    int tolcolor[]={R.drawable.cafe,R.drawable.rojo,R.drawable.dorado, R.drawable.plateado};
    int tempcolor[]={R.drawable.blanco,R.drawable.purpura,R.drawable.azul, R.drawable.naranja,R.drawable.amarillo,R.drawable.rojo, R.drawable.cafe};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tValor=(TextView) findViewById(R.id.tValor);
        tTolerancia=(TextView) findViewById(R.id.tTolerancia);
        tTemp=(TextView) findViewById(R.id.tTemp);
        b1=(Button) findViewById(R.id.b1);
        b2=(Button) findViewById(R.id.b2);
        b3=(Button) findViewById(R.id.b3);
        b4=(Button) findViewById(R.id.b4);
        b5=(Button) findViewById(R.id.b5);
        b6=(Button) findViewById(R.id.b6);
        RGroup =(RadioGroup) findViewById(R.id.RGroup);



    }//oncreate

    public void clickbutton(View view) {
        int id = view.getId();
        if (flag==1) {
            switch (id) {
                case R.id.b1:
                    flagb1 = flagb1 + 1;
                    b1.setBackgroundResource(color[flagb1]);
                    v1 = 10 * flagb1;
                    if (flagb1 == 9) flagb1 = 0;
                    break;

                case R.id.b2:
                    b2.setBackgroundResource(color[flagb2]);
                    v2 = flagb2;
                    //tTemp.setText(String.valueOf(v1 + v2));
                    flagb2 = flagb2 + 1;
                    if (flagb2 == 10) flagb2 = 0;
                    break;
                case R.id.b3:
                    flagaux = 1;
                    if (flagb3 == 7 || flagb3 == 8) {
                        if (flagb3 == 7) b3.setBackgroundResource(color[10]);
                        else b3.setBackgroundResource(color[11]);
                    } else {
                        b3.setBackgroundResource(color[flagb3]);
                    }
                    flagb3 = flagb3 + 1;
                    break;
                case R.id.b4:
                    b4.setBackgroundResource(tolcolor[flagb4]);
                    flagb4 = flagb4 + 1;
                    if (flagb4 == 1) tolerancia = 1;
                    else if (flagb4 == 2) tolerancia = 2;
                    else if (flagb4 == 3) tolerancia = 5;
                    else {tolerancia = 10;flagb4 = 0;}
                    flagaux2=1;
                    break;


            }
            if (flagaux2==0) {
                if (flagb3 < 8) {
                    if (flagaux == 0 && flagb3 == 0) flagb3aux = flagb3;
                    else flagb3aux = flagb3 - 1;
                    flagaux = 0;
                    v3 = (v1 + v2) * Math.pow(10, flagb3aux);
                } else if (flagb3 == 8) {
                    v3 = (v1 + v2) / 10;
                } else if (flagb3 == 9) {
                    v3 = (v1 + v2) / 100;
                    flagb3 = 0;
                }


                tValor.setText(String.valueOf(v3));
            }
            flagaux2 = 0;
            tTolerancia.setText(String.valueOf(tolerancia));
            tTemp.setText("NA");
        }//flag1

        else if (flag==2){//5 bandassss
            switch (id) {
                case R.id.b1:
                    flagb1 = flagb1 + 1;
                    b1.setBackgroundResource(color[flagb1]);
                    v1 = 100 * flagb1;
                    if (flagb1 == 9) flagb1 = 0;
                    break;

                case R.id.b2:
                    b2.setBackgroundResource(color[flagb2]);
                    v2 = 10*flagb2;
                    //tTemp.setText(String.valueOf(v1 + v2));
                    flagb2 = flagb2 + 1;
                    if (flagb2 == 10) flagb2 = 0;
                    break;

                case R.id.b3:
                    b3.setBackgroundResource(color[flagb3]);
                    v3 = flagb3;
                    //tTemp.setText(String.valueOf(v1 + v2));
                    flagb3 = flagb3 + 1;
                    if (flagb3 == 10) flagb3 = 0;
                    break;

                case R.id.b4:
                    flagaux = 1;
                    if (flagb4 == 5 || flagb4 == 6) {
                        if (flagb4 == 5) b4.setBackgroundResource(color[10]);
                        else b4.setBackgroundResource(color[11]);
                    } else {
                        b4.setBackgroundResource(color[flagb4]);
                    }
                    flagb4 = flagb4 + 1;
                    break;
                case R.id.b5:
                    b5.setBackgroundResource(tolcolor[flagb5]);
                    flagb5 = flagb5 + 1;
                    if (flagb5 == 1) tolerancia = 1;
                    else if (flagb5 == 2) tolerancia = 2;
                    else if (flagb5 == 3) tolerancia = 5;
                    else {tolerancia = 10;flagb5 = 0;}
                    flagaux2=1;
                    break;


            }

            if (flagaux2==0) {
                if (flagb4 < 6) {
                    if (flagaux == 0 && flagb4 == 0) flagb4aux = flagb4;
                    else flagb4aux = flagb4 - 1;
                    flagaux = 0;
                    v4 = (v1 + v2 + v3) * Math.pow(10, flagb4aux);
                } else if (flagb4 == 6) {
                    v4 = (v1 + v2 + v3) / 10;
                } else if (flagb4 == 7) {
                    v4 = (v1 + v2 + v3) / 100;
                    flagb4 = 0;
                }
                tValor.setText(String.valueOf(v4));
            }flagaux2 = 0;
            tTolerancia.setText(String.valueOf(tolerancia));
            tTemp.setText("NA");
        }//flag2

        else {switch (id) {//6 bandassss
                case R.id.b1:
                    flagb1 = flagb1 + 1;
                    b1.setBackgroundResource(color[flagb1]);
                    v1 = 100 * flagb1;
                    if (flagb1 == 9) flagb1 = 0;
                    break;

                case R.id.b2:
                    b2.setBackgroundResource(color[flagb2]);
                    v2 = 10*flagb2;
                    //tTemp.setText(String.valueOf(v1 + v2));
                    flagb2 = flagb2 + 1;
                    if (flagb2 == 10) flagb2 = 0;
                    break;

                case R.id.b3:
                    b3.setBackgroundResource(color[flagb3]);
                    v3 = flagb3;
                    //tTemp.setText(String.valueOf(v1 + v2));
                    flagb3 = flagb3 + 1;
                    if (flagb3 == 10) flagb3 = 0;
                    break;
                case R.id.b4:
                    flagaux = 1;
                    if (flagb4 == 5 || flagb4 == 6) {
                        if (flagb4 == 5) b4.setBackgroundResource(color[10]);
                        else b4.setBackgroundResource(color[11]);
                    } else {
                        b4.setBackgroundResource(color[flagb4]);
                    }
                    flagb4 = flagb4 + 1;
                    break;
                case R.id.b5:
                    b5.setBackgroundResource(tolcolor[flagb5]);
                    flagb5 = flagb5 + 1;
                    if (flagb5 == 1) tolerancia = 1;
                    else if (flagb5 == 2) tolerancia = 2;
                    else if (flagb5 == 3) tolerancia = 5;
                    else {tolerancia = 10; flagb5 = 0;}
                    flagaux2=1;
                    break;
                case R.id.b6:
                    b6.setBackgroundResource(tempcolor[flagb6]);
                    flagb6 = flagb6 + 1;
                    if (flagb6 == 1) temp = 1;
                    else if (flagb6 == 2) temp = 5;
                    else if (flagb6 == 3) temp = 10;
                    else if (flagb6 == 4) temp = 15;
                    else if (flagb6 == 5) temp = 25;
                    else if (flagb6 == 6) temp = 50;
                    else {temp = 100; flagb6 = 0;}
                    break;
            }

            if (flagaux2==0) {
                if (flagb4 < 6) {
                    if (flagaux == 0 && flagb4 == 0) flagb4aux = flagb4;
                    else flagb4aux = flagb4 - 1;
                    flagaux = 0;
                    v4 = (v1 + v2 + v3) * Math.pow(10, flagb4aux);
                } else if (flagb4 == 6) {
                    v4 = (v1 + v2 + v3) / 10;
                } else if (flagb4 == 7) {
                    v4 = (v1 + v2 + v3) / 100;
                    flagb4 = 0;
                }
                tValor.setText(String.valueOf(v4));
            }flagaux2 = 0;
            tTolerancia.setText(String.valueOf(tolerancia));
            tTemp.setText(String.valueOf(temp));
        }//flag3

    }//finbutton

    public void clickradio(View view){

        tolerancia=0;temp=0;flag=0;flagb1=0;flagb2=0;flagb3=0;flagb3aux=0;flagaux=0;flagb4=0;flagb4aux=0;flagb5=0;flagb6=0;
        v1=0;v2=0;v3=0;v4=0; flagaux2 = 0;
        b1.setBackgroundResource(gray);b2.setBackgroundResource(gray);b3.setBackgroundResource(gray);
        b4.setBackgroundResource(gray);b5.setBackgroundResource(gray);b6.setBackgroundResource(gray);
        Toast.makeText(MainActivity.this, "Presione la banda para cambiar el color", Toast.LENGTH_LONG).show();

        boolean checked =((RadioButton) view).isChecked();
        int id=view.getId();

        b1.setVisibility(View.INVISIBLE);
        b2.setVisibility(View.INVISIBLE);
        b3.setVisibility(View.INVISIBLE);
        b4.setVisibility(View.INVISIBLE);
        b5.setVisibility(View.INVISIBLE);
        b6.setVisibility(View.INVISIBLE);

        switch (id){
            case R.id.RB1:
                if (checked){
                    b1.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.VISIBLE);
                    b3.setVisibility(View.VISIBLE);
                    b4.setVisibility(View.VISIBLE);
                    tTemp.setText("NA");
                    tValor.setText("0.0");
                    tTolerancia.setText("0.0");
                    flag=1;
                }break;
            case R.id.RB2:
                if (checked){
                    b1.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.VISIBLE);
                    b3.setVisibility(View.VISIBLE);
                    b4.setVisibility(View.VISIBLE);
                    b5.setVisibility(View.VISIBLE);
                    tTemp.setText("NA");
                    tValor.setText("0.0");
                    tTolerancia.setText("0.0");
                    flag=2;
                }break;
            case R.id.RB3:
                if (checked){
                    b1.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.VISIBLE);
                    b3.setVisibility(View.VISIBLE);
                    b4.setVisibility(View.VISIBLE);
                    b5.setVisibility(View.VISIBLE);
                    b6.setVisibility(View.VISIBLE);
                    tTemp.setText("0.0");
                    tValor.setText("0.0");
                    tTolerancia.setText("0.0");
                    flag=3;
                }break;
        }
    }

}
