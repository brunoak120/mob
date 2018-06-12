package com.example.diegoherzer.pizzaria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.diegoherzer.pizzaria.Home.escolha;

public class loginActivity extends AppCompatActivity {

    public static boolean loginFeito;

    private EditText user;
    private EditText senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setValores();



        //Criando botão de login

        Button  bLogin = (Button) findViewById(R.id.btLogin);

        //Criar OnClick para o Botao de login


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(user.getText().toString().equals("admin") && senha.getText().toString().equals("admin")){
                    alert("BEM VINDO ADMIN !");


                    if(escolha == 'a'){
                        gerenciarFunc();



                    }else if(escolha == 'b'){
                        gerenciarPizza();



                    }else if(escolha == 'c') {
                        gerenciarBebida();

                    }


                }else {
                    alert("ACESSO NEGADO");
                }

            }
        });




    }

    private void setValores(){
        user = (EditText) findViewById(R.id.tLogin);
        senha = (EditText) findViewById(R.id.tsenha);
    }

    //Metodo Toast - Retorna informaçao para user
    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }


    public void gerenciarFunc(){
        Intent gerenFunc = new Intent(this, funcionarioActivity.class);
        startActivity(gerenFunc);
    }

    public void gerenciarPizza(){
        Intent gerenPizza = new Intent(this, PIzzaActivity.class);
        startActivity(gerenPizza);
    }

    public void gerenciarBebida(){
        Intent gerenBebida = new Intent(this, BebidaActivity.class);
        startActivity(gerenBebida);
    }

}
