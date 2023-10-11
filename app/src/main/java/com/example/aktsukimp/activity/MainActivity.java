package com.example.aktsukimp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.aktsukimp.R;

public class MainActivity extends AppCompatActivity {


    /* Aqui estamos definindo o que cada campo irá fazer */
    private Button botaoAcessar;
    private EditText campoEmail,campoSenha;
    private Switch tipoAcesso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializaComponentes();
        botaoAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = campoEmail.getText().toString();
                String senha = campoSenha.getText().toString();

                if ( !email.isEmpty()){
                    if (!senha.isEmpty()){
                        //Aqui faz a verificaçao do switch para ver se o usuario quer se cadastrar ou se logar.
                        if (tipoAcesso.isChecked()){  //Cadastro

                        }else {//Login

                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Preencha a Senha!", Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(MainActivity.this, "Preencha o Email!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /*Criando metodo para inicializar os componentes*/

    private void inicializaComponentes(){
        campoEmail = findViewById(R.id.editCadastroEmail);
        campoSenha = findViewById(R.id.editCadastroSenha);
        botaoAcessar = findViewById(R.id.buttonAcesso);
        tipoAcesso = findViewById(R.id.switchAcesso);

    }
}