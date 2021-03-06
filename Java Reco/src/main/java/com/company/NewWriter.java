package com.company;

import net.librec.recommender.item.RecommendedItem;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Colo on 19/11/2017.
 */
public class NewWriter {
    private final List<RecommendedItem> recommended;

    public NewWriter(List<RecommendedItem> recommendedItemList) {
        this.recommended=recommendedItemList;
    }

    public void writeFile() throws IOException {
        List<String> lines=new LinkedList<String>();
        for (RecommendedItem recommendedItem : recommended) {
            String st="Destino:" + recommendedItem.getItemId();
            lines.add(st);
        }
        Path file = Paths.get("data/result/Recomendacion.txt");
        Files.write(file, lines, Charset.forName("UTF-8"));
    }
}
