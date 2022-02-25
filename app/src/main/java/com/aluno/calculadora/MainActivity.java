package com.aluno.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private double operador1;
    private double operador2;

    private String operadores;

    private TextView txt_visor;
    private String aux = null;
    private Button btn_0;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button apagar;
    double resultado = 0;
    private Button btn_ponto;
    private Button btn_igual;
    private Button btn_soma;
    private Button btn_subt;
    private Button btn_divi;
    private Button btn_mult;
    ArrayList<Double> somas = new ArrayList<>();
    String string;
    ArrayList<String> cadeiaString = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador1 = 1;
                txt_visor.setText(String.valueOf("1"));
                cadeiaString.add("1");
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operador1 = 2;
                tecladoNumerico(2);
                cadeiaString.add("2");
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tecladoNumerico(3);
                cadeiaString.add("3");
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tecladoNumerico(4);
                cadeiaString.add("4");
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tecladoNumerico(5);
                cadeiaString.add("5");
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tecladoNumerico(6);
                cadeiaString.add("6");
            }
        });

        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tecladoNumerico(8);
                cadeiaString.add("8");
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadeiaString.add("9");
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tecladoNumerico(7);
                cadeiaString.add("7");
            }
        });
        btn_soma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadeiaString.add("+");
            }
        });
        btn_subt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadeiaString.add("-");
            }
        });
        btn_divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadeiaString.add("/");
            }
        });
        btn_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadeiaString.add("*");
            }
        });
        apagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < cadeiaString.size(); i++) {
                    cadeiaString.clear();
                    resultado = 0;
                    txt_visor.setText("0.0");
                }
            }
        });
        btn_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < cadeiaString.size(); i++) {
                    if(cadeiaString.get(i).equals("+")){
                        resultado = Double.parseDouble(cadeiaString.get(i-1)) + Double.parseDouble(cadeiaString.get(i+1)) + resultado;
                        cadeiaString.set(i-1, "0");
                        cadeiaString.set(i, "0");
                        cadeiaString.set(i+1, "0");
                    }
                    if(cadeiaString.get(i).equals("-")){

                        resultado = Double.parseDouble(cadeiaString.get(i-1)) - Double.parseDouble(cadeiaString.get(i+1)) + resultado;
                        cadeiaString.set(i-1, "0");
                        cadeiaString.set(i, "0");
                        cadeiaString.set(i+1, "0");
                    }
                    if(cadeiaString.get(i).equals("/")){
                        if(resultado == 0) {
                            resultado = Double.parseDouble(cadeiaString.get(i - 1)) / Double.parseDouble(cadeiaString.get(i + 1));
                            cadeiaString.set(i - 1, "0");
                            cadeiaString.set(i, "0");
                            cadeiaString.set(i + 1, "0");
                        }else{
                            resultado = resultado / Double.parseDouble(cadeiaString.get(i + 1));
                            cadeiaString.set(i - 1, "0");
                            cadeiaString.set(i, "0");
                            cadeiaString.set(i + 1, "0");
                        }
                    }
                    if(cadeiaString.get(i).equals("*")){
                        if(resultado == 0) {
                            resultado = 1;
                            resultado = Double.parseDouble(cadeiaString.get(i - 1)) * Double.parseDouble(cadeiaString.get(i + 1));
                            cadeiaString.set(i - 1, "0");
                            cadeiaString.set(i, "0");
                            cadeiaString.set(i + 1, "0");
                        }else{
                            resultado = resultado * Double.parseDouble(cadeiaString.get(i + 1));
                            cadeiaString.set(i - 1, "0");
                            cadeiaString.set(i, "0");
                            cadeiaString.set(i + 1, "0");
                        }
                    }
                }
                txt_visor.setText(String.valueOf(resultado));


            }
        });
    }

    private void inicializar(){
        txt_visor =(TextView) findViewById(R.id.txt_visor);
        btn_0 = (Button) findViewById(R.id.bt_0);
        btn_1 = (Button) findViewById(R.id.bt_1);
        btn_2 = (Button) findViewById(R.id.bt_2);
        btn_3 = (Button) findViewById(R.id.bt_3);
        btn_4 = (Button) findViewById(R.id.bt_4);
        btn_5 = (Button) findViewById(R.id.bt_5);
        btn_6 = (Button) findViewById(R.id.bt_6);
        btn_7 = (Button) findViewById(R.id.bt_7);
        btn_8 = (Button) findViewById(R.id.bt_8);
        btn_9 = (Button) findViewById(R.id.bt_9);
        apagar = (Button) findViewById(R.id.apagar);
        btn_soma = (Button) findViewById(R.id.bt_soma);
        btn_divi = (Button) findViewById(R.id.bt_divi);
        btn_subt = (Button) findViewById(R.id.bt_subt);
        btn_mult = (Button) findViewById(R.id.bt_mult);

        btn_ponto= (Button) findViewById(R.id.bt_ponto);

        btn_igual = (Button) findViewById(R.id.bt_igual);
    }


    private void tecladoNumerico(int leNumero) {

        aux = String.valueOf(leNumero);
        txt_visor.setText(aux);

    }
    private void ponto(String ponto){

        aux = txt_visor.getText().toString();
        txt_visor.setText(aux + ponto);

    }
    private void limparVisor() {

        txt_visor.setText("");

    }

    private void operacoes(String operadores) {

        this.operadores = operadores;

        if (operadores == "+") {

            operador1 = Double.parseDouble(txt_visor.getText().toString().trim());
            limparVisor();

        } else if (operadores == "-") {

            operador1 = Double.parseDouble(txt_visor.getText().toString().trim());
            limparVisor();

        } else if (operadores == "*") {

            operador1 = Double.parseDouble(txt_visor.getText().toString().trim());
            limparVisor();

        } else if (operadores == "/") {

            operador1 = Double.parseDouble(txt_visor.getText().toString().trim());
            limparVisor();

        }

    }
    private void igual() {

        if(!txt_visor.getText().toString().trim().equals("")){

            if (operadores.equals("+")) {

                operador2 = operador1 + Double.parseDouble(txt_visor.getText().toString().trim());

            } else if (operadores == "-") {

                operador2 = operador1 - Double.parseDouble(txt_visor.getText().toString().trim());

            } else if (operadores == "*") {

                operador2 = operador1 * Double.parseDouble(txt_visor.getText().toString().trim());

            } else if (operadores == "/") {

                if(operador1 == 0){

                    operador2 = 0;

                } else {

                    operador2 = operador1 / Double.parseDouble(txt_visor.getText().toString().trim());

                }

            }

        }else{

            operador2 = 0;

        }

        txt_visor.setText(String.valueOf(operador2));

    }


}