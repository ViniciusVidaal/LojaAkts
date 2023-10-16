package com.example.aktsukimp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;

import com.example.aktsukimp.R;
import com.example.aktsukimp.activity.helper.ConfiguracaoFirebase;
import com.google.firebase.auth.FirebaseAuth;

public class AnunciosActivity extends AppCompatActivity {



    private FirebaseAuth autenticacao = ConfiguracaoFirebase.getReferenciaAutenticacao();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anuncios);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        return super.onPrepareOptionsMenu(menu);
    }
}