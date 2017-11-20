package com.company;

import net.librec.recommender.item.RecommendedItem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecomendationController {



    @RequestMapping("/recomendar")
    public Recomendator obtenerRecomendacion(@RequestParam(value="Martin", defaultValue="51") String name ) {

        try {
            List<RecommendedItem> recommendedItemList = Recomendator.getInstance().recomend("51");
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
        return null;
    }
}
