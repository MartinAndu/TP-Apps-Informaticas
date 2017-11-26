package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JSONReader {
    JSONObject datos;
    String buffer="";
    JSONReader(){
        try {
            FileReader fileR =  new FileReader("../src/json/placesToVisitDetails.json");

            JSONObject datos = new JSONObject();
            String archivo;

            BufferedReader br = new BufferedReader(fileR);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                buffer+=linea;
            System.out.println(buffer);
            //JSONParser parser = new JSONParser();
            //datos = (JSONObject) parser.parse(buffer);
            //System.out.println(datos);
            //file.write(obj.toJSONString());
            //file.flush();
            fileR.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public String getDatos(){
        return buffer;
    }
}
