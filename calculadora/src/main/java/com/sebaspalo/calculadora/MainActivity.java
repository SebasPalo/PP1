package com.sebaspalo.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText eNumero, eResultado;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bCE,bdiv,bpor,bresta,bsuma,bigual,bpunto;
    int flag1=20,flag2,flag3,flagigual,flagNoperacion;
    double resultado;
    String opp1,opp2, operador=(""), operador_sig,opeaux;

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
        bCE =(Button) findViewById(R.id.bCE);bdiv =(Button) findViewById(R.id.bdiv);bpor=(Button) findViewById(R.id.bpor);
        bigual= (Button) findViewById(R.id.bigual);bpunto=(Button) findViewById(R.id.bpunto);

    }

    public void click(View view){
    int id=view.getId();
        switch (id){
            case R.id.b0: if (flagigual==1){eNumero.setText("");flagigual=0;}
                eNumero.setText(eNumero.getText()+"0");
                flag1=0;
                break;
            case R.id.b1: if (flagigual==1){eNumero.setText("");flagigual=0;}
                eNumero.setText(eNumero.getText()+"1");
                flag1=0;
                break;
            case R.id.b2: if (flagigual==1){eNumero.setText("");flagigual=0;}
                eNumero.setText(eNumero.getText()+"2");
                flag1=0;
                break;
            case R.id.b3: if (flagigual==1){eNumero.setText("");flagigual=0;}
                eNumero.setText(eNumero.getText()+"3");
                flag1=0;
                break;
            case R.id.b4: if (flagigual==1){eNumero.setText("");flagigual=0;}
                eNumero.setText(eNumero.getText()+"4");
                flag1=0;
                break;
            case R.id.b5: if (flagigual==1){eNumero.setText("");flagigual=0;}
                eNumero.setText(eNumero.getText()+"5");
                flag1=0;
                break;
            case R.id.b6: if (flagigual==1){eNumero.setText("");flagigual=0;}
                eNumero.setText(eNumero.getText()+"6");
                flag1=0;
                break;
            case R.id.b7: if (flagigual==1){eNumero.setText("");flagigual=0;}
                eNumero.setText(eNumero.getText()+"7");
                flag1=0;
                break;
            case R.id.b8: if (flagigual==1){eNumero.setText("");flagigual=0;}
                eNumero.setText(eNumero.getText()+"8");
                flag1=0;
                break;
            case R.id.b9: if (flagigual==1){eNumero.setText("");flagigual=0;}
                eNumero.setText(eNumero.getText()+"9");
                flag1=0;
                break;
            case R.id.bpunto: if (flagigual==1){eNumero.setText(""); flagigual=0;}
                eNumero.setText(eNumero.getText()+".");
                flag1=0;
                break;
            case R.id.bCE:eNumero.setText("");
                operador=("");
                resultado=0;
                eResultado.setText("");
                flag1=3;  //para q no entre a ningun if
                flag2=0; //para q vuelva a coger los dos primeros operandos
                flag3=0;
                break;

            case R.id.bigual:if (flag1==1) {flagNoperacion=1;}
                if (flagigual==1){eNumero.setText("");   //Esto es un CE
                    operador=("");
                    resultado=0;
                    eResultado.setText("");
                    flag1=3;  //para q no entre a ningun if
                    flag2=0; //para q vuelva a coger los dos primeros operandos
                    flag3=0;
                    eNumero.setBackgroundColor(8);
                    flagigual=0;
                    }
                else {
                flag1=1;
               // flag2 = 0;
               // flag3=0;
                flagigual=1;}
                break;

            case R.id.bsuma: operador="+"; flagigual=0;
                if (flag1==0){
                //op1=Double.parseDouble(eNumero.getText().toString());
                opp1=eNumero.getText().toString();
                eNumero.setText(eNumero.getText()+"+");flag1=1;}
                else if (flag1==1){eNumero.setText(opp1+"+");flag3=0;flag1=1;}

                break;

            case R.id.bresta: operador="-";flagigual=0;
                if (flag1==0){
                    opp1=eNumero.getText().toString();
                    eNumero.setText(eNumero.getText()+"-");flag1=1;}
                else if (flag1==1){eNumero.setText(opp1+"-");flag3=0;flag1=1;}

                break;

            case R.id.bpor: operador="*";flagigual=0;
                if (flag1==0){
                    opp1=eNumero.getText().toString();
                    eNumero.setText(eNumero.getText()+"*");flag1=1;}
                else if (flag1==1){eNumero.setText(opp1+"*");flag3=0;flag1=1;}

                break;

            case R.id.bdiv: operador="/";flagigual=0;
                if (flag1==0){
                    opp1=eNumero.getText().toString();
                    eNumero.setText(eNumero.getText()+"/");flag1=1;}
                else if (flag1==1){eNumero.setText(opp1+"/"); flag3=0;flag1=1;}

                break;


        }
        String frase = eNumero.getText().toString();
        String delims = "[+\\-*/]+"; // so the delimiters are:  + - * /
        String[] operandos = frase.split(delims);
        int n=operandos.length;
        if (flag1==1) {if (flag3==0){operador_sig=operador; operador=("");flag3=1;}//para q no entre a los if del operador..saber si ya habia operador
                        else if (flag3 ==1){opeaux=operador_sig;
                             operador_sig=operador;
                             operador=opeaux;
        if (flagNoperacion==1){operador="";flagNoperacion = 0;}}

           // for (int i = 0; i < operandos.length; i++){
         //   System.out.println(operandos[i]);
                //cadena.length()-1
             if (operador.equals("+")){
                 if (flag2==0) {resultado = Double.parseDouble(operandos[0]) + Double.parseDouble(operandos[1]);
                     flag2=1;}
                 else if (flag2==1) resultado = resultado + Double.parseDouble(operandos[n-1]);}
                //resultado = Double.parseDouble(operandos[0]) + Double.parseDouble(operandos[1]);
             else if (operador.equals("-")){
                 if (flag2==0) {resultado = Double.parseDouble(operandos[0]) - Double.parseDouble(operandos[1]);
                     flag2=1;}
                 else if (flag2==1)resultado = resultado - Double.parseDouble(operandos[n-1]);}
             else if (operador.equals("*")){
                 if (flag2==0) {resultado = Double.parseDouble(operandos[0]) * Double.parseDouble(operandos[1]);
                     flag2=1;}
                 else if (flag2==1) resultado = resultado * Double.parseDouble(operandos[n-1]);}
             else if (operador.equals("/")){
                 if (flag2==0) {resultado = Double.parseDouble(operandos[0]) / Double.parseDouble(operandos[1]);
                     flag2=1;}
                 else if (flag2==1) resultado = resultado / Double.parseDouble(operandos[n-1]);}
             else eResultado.setText("hiho");

            eResultado.setText(String.valueOf(resultado));
            }
        if (flagigual==1){eNumero.setText(String.valueOf(resultado));
            eResultado.setText("");
            opp1=eNumero.getText().toString();
            operador="";
            flag2=0;
            flag3=0;
            resultado=0;}

            //resultado_temp=0;

//AL presionar igual cuando se habia introducido un operador=>  resultado= resultadoOK*(operacion q se habia escrito)*ultimo operando

    }


}
