package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
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
            System.out.println(e);
        }
    }
}
