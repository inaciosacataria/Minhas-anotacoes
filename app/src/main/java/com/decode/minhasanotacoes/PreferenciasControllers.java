package com.decode.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class PreferenciasControllers {

    private Context context;
    private SharedPreferences preferences ;
    private SharedPreferences.Editor editor;
    private String ARQUIVO="ANOTACOES";
    private String key="anotacoes";


    public PreferenciasControllers(Context context) {
        this.context=context;
        preferences=context.getSharedPreferences(ARQUIVO,0);
    }

    public void salvar(String anotacoes){
        editor= preferences.edit();
        editor.putString(key,anotacoes);
        editor.commit();
    }

    public String recuperarAnotacoess(){
        String anotacao=""+ preferences.getString(key,"");
      return anotacao ;
    }
}
