package com.example.aktsukimp.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.aktsukimp.R;
import com.example.aktsukimp.activity.helper.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;

public class AnunciosActivity extends AppCompatActivity {

    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);

        // configuração iniciais para ver se o usuário esta logado ou nao
        autenticacao = ConfiguracaoFirebase.getReferenciaAutenticacao();

        // autenticacao.signOut();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (autenticacao.getCurrentUser() == null){  //usuario deslogado
            menu.setGroupVisible(R.id.group_deslogado, true);
        }else { //usuario logado
            menu.setGroupVisible(R.id.group_logado, true);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_cadastrar){
            startActivity(new Intent(getApplicationContext(),CadastroActivity.class));
        } else if (item.getItemId() == R.id.menu_sair) {
            autenticacao.signOut();
            invalidateOptionsMenu();

        }


        return super.onOptionsItemSelected(item);
    }
}