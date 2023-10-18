package com.example.aktsukimp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.aktsukimp.R;
import com.example.aktsukimp.activity.helper.ConfiguracaoFirebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity {


    /* Aqui estamos definindo o que cada campo irá fazer */
    private Button botaoAcessar;
    private EditText campoEmail, campoSenha;
    private Switch tipoAcesso;

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        inicializaComponentes();
        autenticacao = ConfiguracaoFirebase.getReferenciaAutenticacao();

        botaoAcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = campoEmail.getText().toString();
                String senha = campoSenha.getText().toString();

                if (!email.isEmpty()) {
                    if (!senha.isEmpty()) {
                        //Aqui faz a verificaçao do switch para ver se o usuario quer se cadastrar ou se logar.
                        if (tipoAcesso.isChecked()) {  //Cadastro
                            autenticacao.createUserWithEmailAndPassword(
                                    email, senha
                            ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(CadastroActivity.this, "Cadastro Realizado Com Sucesso!", Toast.LENGTH_SHORT).show();



                                    } else {

                                        String erroExcecao = "";

                                        try {
                                            throw task.getException();
                                        } catch (FirebaseAuthWeakPasswordException e) {
                                            erroExcecao = "Digite uma senhe mais forte!";

                                        } catch (FirebaseAuthInvalidCredentialsException e) {
                                            erroExcecao = "Por favor, digite um email válido";
                                        } catch (FirebaseAuthUserCollisionException e) {
                                            erroExcecao = "Esse Email Ja esta Cadastrado";
                                        } catch (Exception e) {
                                            erroExcecao = "Ao cadastrar usuário: " + e.getMessage();
                                            e.printStackTrace();
                                        }
                                        Toast.makeText(CadastroActivity.this, "Erro: " + erroExcecao,
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                            });

                        } else {//Login

                            autenticacao.signInWithEmailAndPassword(
                                    email, senha
                            ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()){
                                        Toast.makeText(CadastroActivity.this,
                                                "Logado Com Sucesso",
                                                Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), AnunciosActivity.class));

                                    }else {
                                        Toast.makeText(CadastroActivity.this,
                                                "Erro ao fazer login" + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    }

                                }
                            });

                        }
                    } else {
                        Toast.makeText(CadastroActivity.this, "Preencha a Senha!", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(CadastroActivity.this, "Preencha o Email!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    /*Criando metodo para inicializar os componentes*/

    private void inicializaComponentes() {
        campoEmail = findViewById(R.id.editCadastroEmail);
        campoSenha = findViewById(R.id.editCadastroSenha);
        botaoAcessar = findViewById(R.id.buttonAcesso);
        tipoAcesso = findViewById(R.id.switchAcesso);
    }
}