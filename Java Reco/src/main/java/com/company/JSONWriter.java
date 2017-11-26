package com.company;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
public class JSONWriter {
    JSONWriter(JSONObject obj){
        try {

            FileWriter file = new FileWriter("../src/json/placesToVisitDetails.json");
            file.write(obj.toJSONString());
            file.flush();
            file.close();

        } catch (IOException e) {
            //manejar error
        }
    }
}
