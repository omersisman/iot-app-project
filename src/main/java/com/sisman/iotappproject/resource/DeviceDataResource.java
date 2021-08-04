package com.sisman.iotappproject.resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DeviceDataResource {

    public String getDeviceData(String customId, String xToken) throws Exception {

        if(xToken == null){
            throw new Exception("Need to login before continue!");
        }

        String query_url = "https://iotapi.skywaveiot.com/v1/vendor/valid-device-data?customId=" + customId;

        String result = "";

        try {

            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            conn.setRequestProperty("x-xsrf-token", xToken);
            //System.out.println("::::::"+xsrfToken);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            // read the response
            InputStream in = new BufferedInputStream(conn.getInputStream());
            result = IOUtils.toString(in, "UTF-8");
            //System.out.println(":::::::::"+result);
            in.close();
            conn.disconnect();

        }catch (Exception e){
            System.out.println(e);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(result);
        String prettyJsonString = gson.toJson(je);

        return prettyJsonString;

    }

}
