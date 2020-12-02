package com.decode.minhasanotacoes;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtAnotacoes;
    final String ARQUIVO= "ARQUIVO";
    PreferenciasControllers preferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAnotacoes= findViewById(R.id.txtAnotacoes);

        // instancia da classe salva dados
        preferencias= new PreferenciasControllers(getApplicationContext());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(txtAnotacoes.getText().toString().equals("")){
                   Snackbar.make(
                           view,
                           "Anotacao vazia, nao foi possivel guardar.",
                           BaseTransientBottomBar.LENGTH_SHORT
                   ).show();
                }else {
                 String anotacoes=   txtAnotacoes.getText().toString();
                preferencias.salvar(anotacoes);
                    Snackbar.make(
                            view,
                            "Anotacao salva.",
                            BaseTransientBottomBar.LENGTH_SHORT
                    ).show();
                }
            }
        });
        String anotacao= preferencias.recuperarAnotacoess();
        if(!anotacao.equals("")){
            txtAnotacoes.setText(anotacao);
        }

    }



}
