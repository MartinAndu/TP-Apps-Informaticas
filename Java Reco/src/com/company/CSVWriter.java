package com.company;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Colo on 21/11/2017.
 */
public class CSVWriter {
    public void write(String lineaCSV, String direccion) throws IOException {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("data/arff/rating/RecosDeOtros.csv", true));
            out.write(lineaCSV);
            System.out.printf("Agregado al csv" + " " + lineaCSV);
        } catch (IOException e) {
            // error processing code
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}


