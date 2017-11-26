package com.company;

import net.librec.recommender.item.RecommendedItem;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RecomendationController {


    @CrossOrigin("*")
    @RequestMapping(value="/recomendar",method= RequestMethod.POST)
    public List<RecommendedItem> obtenerRecomendacion(@RequestParam(value="Martin", defaultValue="51") String userName ) {
        List<RecommendedItem> recommendedItemList = new ArrayList<>();
        try {
            recommendedItemList = Recomendator.getInstance().recomend(userName);
            // print filter result
            Integer counter = 0;
            for (RecommendedItem recommendedItem : recommendedItemList) {
                System.out.println(
                        "Usuario:" + recommendedItem.getUserId() + " " +
                                "Destino:" + recommendedItem.getItemId() + " " +
                                "Valor:" + recommendedItem.getValue()
                );
                               ;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return recommendedItemList;
    }

    @CrossOrigin("*")
    @RequestMapping(value="/likear",method= RequestMethod.POST)
    public String obtenerRecomendacion(@RequestBody LikeParams request) {
        CSVWriter writer=new CSVWriter();
        String saltoDeLinea=System.getProperty("line.separator");
        String lineaCSV= request.getUserName() +","+ request.getPlace() + "," + request.getRating() +","+ request.getPrice() + "," + request.getEnvironment() + saltoDeLinea;
        try {
            writer.write(lineaCSV,"data/arff/rating/RecosDeOtros.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "OK";
    }

    @CrossOrigin("*")
    @RequestMapping(value="/uploadFile",method= RequestMethod.POST)
    public String uploadFile(@RequestBody FileRequest request) {
        FileCopy copiador = new FileCopy(request.getRuta(), request.getName());

        return "OK";
    }
}
