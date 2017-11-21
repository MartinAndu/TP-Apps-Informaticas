package com.company;

import net.librec.recommender.item.RecommendedItem;
import org.springframework.web.bind.annotation.*;

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
            Integer counter=0;
            for (RecommendedItem recommendedItem : recommendedItemList) {
                System.out.println(
                        "Usuario:" + recommendedItem.getUserId() + " " +
                                "Destino:" + recommendedItem.getItemId() + " " +
                                "Valor:" + recommendedItem.getValue()
                );

                if (counter != 500) {
                    counter++;
                } else {
                    break;
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return recommendedItemList;
    }
}
