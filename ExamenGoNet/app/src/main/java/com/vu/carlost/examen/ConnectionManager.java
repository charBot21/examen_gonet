package com.vu.carlost.examen;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by CarlosT on 15/02/2018.
 */

public class ConnectionManager {
    private static ConnectionManager connectionManager = new ConnectionManager();

    public static ConnectionManager getInstance(){
        //
        return connectionManager;
    }

    //envio
    public void sendLogin(LoginActivity pantalla, String usr, String psswd){
        JSONObject json = createJson(usr, psswd);

        RestSimpleAsync restSimpleAsync = new RestSimpleAsync(pantalla);
        restSimpleAsync.execute(json);
    }//sendLogin

    private JSONObject createJson(String usr, String psswd) {
        JSONObject datos = new JSONObject();
        JSONObject usuario = new JSONObject();

        try{
            usuario.put("pass", psswd);
            usuario.put("user", usr);

            datos.put("data", usuario);
        }catch (JSONException e){
            e.printStackTrace();
        }//catch

        //Regresamos los datos
        return datos;
    }//JSONObject
}
