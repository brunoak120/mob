package com.example.diegoherzer.pizzaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.example.diegoherzer.pizzaria.loginActivity.loginFeito;


public class Home extends AppCompatActivity {

        //variavel que identifica a opção que o usuario escolhe
        public static char escolha;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        //Botoes da activity Home

        Button gereniciarFunc = (Button) findViewById(R.id.btnGerenciarFuncionario);
        Button gerenciarPizza = (Button) findViewById(R.id.btnGerenciarPizza);
        Button gerenciarBebida = (Button) findViewById(R.id.btnGerenciarBebida);
        Button realizarVenda = (Button) findViewById(R.id.btnIniciarVenda);




        //Acessos que modificam informação de algum dado dos atividades precisam de direito de ADM


        //Gerenciamento de Funcionarios
/**************************************************************************************************************************************************************************************************************/

       gereniciarFunc.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               escolha = 'a';
               autentificacao();


           }
       });

        //Gerenciamento de Pizzas
/**************************************************************************************************************************************************************************************************************/

        gerenciarPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escolha = 'b';
                autentificacao();
            }
        });

        //Gerenciamento de Bebidas
/**************************************************************************************************************************************************************************************************************/
        gerenciarBebida.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escolha = 'c';
                autentificacao();

            }
        }));

        //Realizar vendas
/**************************************************************************************************************************************************************************************************************/
        realizarVenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }



    //Classe que roda a activity login
    /**************************************************************************************************************************************************************************************************************/
    public void autentificacao(){
        Intent intent = new Intent(this, loginActivity.class);
        startActivity(intent);
    }
    /**************************************************************************************************************************************************************************************************************/



}
