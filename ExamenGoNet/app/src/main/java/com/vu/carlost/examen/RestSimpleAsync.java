package com.vu.carlost.examen;


import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


/**
 * Created by CarlosT on 15/02/2018.
 */

public class RestSimpleAsync extends AsyncTask<Object, String, String> {

    public RestSimpleAsync(LoginActivity pantalla){
        mL = (RestSimpleListener) pantalla;
    }

    StringBuffer c = new StringBuffer("");

    public RestSimpleListener mL;

    public interface RestSimpleListener{
        public void sendResult(String mR);
    }

    //
    @Override
    protected String doInBackground(Object[] params){
        HttpURLConnection connection = null;

        try{
            //nos conectamos a la URL con los datos
            URL url = new URL("https://agentemovil.pagatodo.com/AgenteMovil.svc/agMov/login");
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("SO","Android");
            connection.setRequestProperty("Version","2.5.2");
            connection.setDoInput(true);

            //
            String mJson = params[0].toString();
            //byte[] outputInBytes = new mJson.getBytes("UTF-8");
            OutputStream os = connection.getOutputStream();
            //os.write(outputInBytes);
            os.close();
            connection.connect();

            //
            int statusCode = connection.getResponseCode();
            if(statusCode != HttpsURLConnection.HTTP_OK){
                //
            }else {
                InputStream inputStream = connection.getInputStream();
                BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while( (line = rd.readLine()) != null ){
                    c.append(line);
                }
            }//else
        }catch (Exception e){
            //excepcion
        }

        return null;
    }//doInBackground

    @Override
    protected void onPostExecute(String resultado){
        mL.sendResult(resultado);
        super.onPostExecute(resultado);
    }

}//RestSimpleAsync
