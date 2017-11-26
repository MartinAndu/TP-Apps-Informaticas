package com.company;

import net.librec.recommender.item.RecommendedItem;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
        System.out.println(request.availability);
        System.out.println(request.ruta);
        FileCopy copiador = new FileCopy(request.getRuta(), request.getName());
        JSONReader reader = new JSONReader();
        JSONObject obj=null;
        String jsonString = reader.getDatos();
        System.out.println("jsonString" + jsonString);
        JSONParser parser = new JSONParser();
        try {
            obj = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JSONObject lista = new JSONObject();
        lista.put("title",request.getTitle());
        lista.put("name", request.getName());
        lista.put("description", request.getDescription());
        lista.put("availability",request.getAvailability());
        lista.put("type",request.getType());
        lista.put("environment",request.getEnvironment());
        obj.put(request.getName(),lista);
        JSONWriter jsonWriter = new JSONWriter(obj);
        return "OK";
    }
}
