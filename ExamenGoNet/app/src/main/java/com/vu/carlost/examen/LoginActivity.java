package com.vu.carlost.examen;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements RestSimpleAsync.RestSimpleListener {
    //Variables que nos servirán para leer lo que tenemos en nuestros input Text
    EditText usr, psswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Orientación siempre vertical
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Elementos a leer
        setIngresar();
    }

    //Ingreso de datos
    private void setIngresar(){
        usr = (EditText)findViewById(R.id.usuario);
        psswd = (EditText)findViewById(R.id.pass);
    }

    //Conexion a servicio
    public void aInicio(View view){
        String user = usr.getText().toString();
        String password = psswd.getText().toString();

        int contador = 0;

        //primeras validaciones
        if(!user.equals("") && !user.isEmpty()){
            contador++;
        }
        if(!password.equals("") && !password.isEmpty()){
            contador++;
        }

        //Validacion de la cuenta para identificar que no hay campos vacios
        if(contador==2){
            ConnectionManager.getInstance().sendLogin(this, user, password);
        }else {
            //En caso de que los valores no sean correctos, enviamos mensaje en pantalla
            Toast.makeText(this, "Ingreso incorrecto, verificar.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void sendResult(String mResult){
        int idUser = 0;
        try {
            JSONObject oneObject = new JSONObject(mResult);

            idUser = oneObject.getInt("id_user");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if(idUser == 11){
            Intent intent = new Intent(this, ContenidoActivity.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Error en usuario o contraseña", Toast.LENGTH_SHORT).show();
        }
    }//sendResult

    public void onLogin(View view) {
        //Elementos a leer
        setIngresar();

        if( (usr.getText().toString().equals("Luis")) || (usr.getText().toString().equals("Luis ")) && (psswd.getText().toString().equals("1")) ){
            Toast.makeText(LoginActivity.this, "Acceso correto", Toast.LENGTH_SHORT).show();
            Intent profile = new Intent(LoginActivity.this,ContenidoActivity.class);
            startActivity(profile);
        }

    }
}
