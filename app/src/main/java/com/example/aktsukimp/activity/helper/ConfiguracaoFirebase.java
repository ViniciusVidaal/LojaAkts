package com.example.aktsukimp.activity.helper;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ConfiguracaoFirebase {



    private static DatabaseReference referenciaFirebase;
    private static FirebaseAuth referenciaAutenticacao;
    private static StorageReference referenciaStorage;

    //Aqui estou retornando a referencia do firebase
    public static DatabaseReference getFirebase() {
        if (referenciaFirebase == null) {
            referenciaFirebase = FirebaseDatabase.getInstance().getReference();
        }
        return  referenciaFirebase;
    }
    //aqui estou retornaando a instancia do FireBaseAuth
    public static FirebaseAuth getReferenciaAutenticacao() {
        if ( referenciaAutenticacao == null){
            referenciaAutenticacao = FirebaseAuth.getInstance();
        }
        return referenciaAutenticacao;
    }
    //aqui estou retornando a instancia do StorageReference
    public static  StorageReference getReferenciaStorage(){
        if (referenciaStorage == null){
            referenciaStorage = FirebaseStorage.getInstance().getReference();
        }
        return referenciaStorage;
    }
}


