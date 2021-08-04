package com.sisman.iotappproject.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class LoginResource {

    private String xToken = null;

    public String loginWithCredentials(String username, String password){

        String query_url = "https://iotapi.skywaveiot.com/v1/login/ENT";
        String json = "{\"username\":\"" + username + "\", \"password\":\"" + password + "\"}";
        String result = "";

        try {

            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            OutputStream os = conn.getOutputStream();
            os.write(json.getBytes("UTF-8"));
            os.close();
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            System.out.println("result after Reading JSON Response");
            JSONObject myResponse = new JSONObject(result);
            System.out.println("tokenExpirationDate- "+myResponse.getString("tokenExpirationDate"));
            System.out.println("token- "+myResponse.getString("token"));
            xToken = myResponse.getString("token");
            in.close();
            conn.disconnect();

        }catch (Exception e){
            System.out.println(e);
        }

        //pretty looking json
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(result);
        String prettyJsonString = gson.toJson(je);

        return prettyJsonString;

    }

    public String getXToken(){ return xToken; }

}
