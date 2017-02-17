package com.sebaspalo.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText eNumero, eResultado;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bCE,bdiv,bpor,bresta,bsuma,bigual,bpunto;
    int flag1;
    double op1,op2,resultado,resultado_temp;
    String opp1,opp2, operador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNumero = (EditText)findViewById (R.id.eNumero);
        eResultado =(EditText)findViewById(R.id.eResultado);
        b1 = (Button) findViewById(R.id.b1);b2 = (Button) findViewById(R.id.b2);b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);b5 = (Button) findViewById(R.id.b5);b6 = (Button) findViewById(R.id.b6);
        b7 = (Button) findViewById(R.id.b7);b8 = (Button) findViewById(R.id.b8);b9 = (Button) findViewById(R.id.b9);
        b0 = (Button) findViewById(R.id.b0);bsuma = (Button) findViewById(R.id.bsuma);bresta = (Button) findViewById(R.id.bresta);
    }

    public void click(View view){
    int id=view.getId();
        switch (id){
            case R.id.b0:eNumero.setText(eNumero.getText()+"0");
                flag1=0;
                break;
            case R.id.b1:eNumero.setText(eNumero.getText()+"1");
                flag1=0;
                break;
            case R.id.b2:eNumero.setText(eNumero.getText()+"2");
                flag1=0;
                break;
            case R.id.b3:eNumero.setText(eNumero.getText()+"3");
                flag1=0;
                break;
            case R.id.b4:eNumero.setText(eNumero.getText()+"4");
                flag1=0;
                break;
            case R.id.b5:eNumero.setText(eNumero.getText()+"5");
                flag1=0;
                break;
            case R.id.b6:eNumero.setText(eNumero.getText()+"6");
                flag1=0;
                break;
            case R.id.b7:eNumero.setText(eNumero.getText()+"7");
                flag1=0;
                break;
            case R.id.b8:eNumero.setText(eNumero.getText()+"8");
                flag1=0;
                break;
            case R.id.b9:eNumero.setText(eNumero.getText()+"9");
                flag1=0;
                break;
            case R.id.bpunto:eNumero.setText(eNumero.getText()+".");
                flag1=0;
                break;

            case R.id.bsuma: operador="+";
                if (flag1==0){
                //op1=Double.parseDouble(eNumero.getText().toString());
                opp1=eNumero.getText().toString();
                eNumero.setText(eNumero.getText()+"+");}
                else{eNumero.setText(opp1+"+");}
                flag1=1;
                break;

            case R.id.bresta: operador="-";
                if (flag1==0){
                    opp1=eNumero.getText().toString();
                    eNumero.setText(eNumero.getText()+"-");}
                else{eNumero.setText(opp1+"-");}
                flag1=1;
                break;

            case R.id.bpor: operador="*";
                if (flag1==0){
                    opp1=eNumero.getText().toString();
                    eNumero.setText(eNumero.getText()+"*");}
                else{eNumero.setText(opp1+"*");}
                flag1=1;
                break;

            case R.id.bdiv: operador="/";
                if (flag1==0){
                    opp1=eNumero.getText().toString();
                    eNumero.setText(eNumero.getText()+"/");}
                else{eNumero.setText(opp1+"/");}
                flag1=1;
                break;


        }
        String frase = eNumero.getText().toString();
        String delims = "[+\\-*/]+"; // so the delimiters are:  + - * /
        String[] operandos = frase.split(delims);
        if (operandos.length>1) {
            for (int i = 0; i < operandos.length; i++){
         //   System.out.println(operandos[i]);
                //cadena.length()-1
             if (operador.equals("+"))
                resultado_temp = resultado_temp + Double.parseDouble(operandos[i]);
                //resultado = Double.parseDouble(operandos[0]) + Double.parseDouble(operandos[1]);
             else if (operador.equals("-"))
                resultado_temp = Double.parseDouble(operandos[0]) - Double.parseDouble(operandos[1]);
             else if (operador.equals("*"))
                resultado_temp = Double.parseDouble(operandos[0]) * Double.parseDouble(operandos[1]);
             else resultado_temp = Double.parseDouble(operandos[0]) / Double.parseDouble(operandos[1]);
            }
            resultado=resultado_temp;
            eResultado.setText(String.valueOf(resultado));
            resultado_temp=0;
        }


    }


}
