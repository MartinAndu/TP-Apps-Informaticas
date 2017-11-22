package com.company;



import net.librec.conf.Configuration;
import net.librec.data.model.TextDataModel;
import net.librec.eval.RecommenderEvaluator;
import net.librec.eval.rating.RMSEEvaluator;
import net.librec.filter.GenericRecommendedFilter;
import net.librec.job.RecommenderJob;
import net.librec.math.algorithm.Randoms;
import net.librec.recommender.Recommender;
import net.librec.recommender.RecommenderContext;
import net.librec.recommender.cf.ItemKNNRecommender;
import net.librec.recommender.item.RecommendedItem;
import net.librec.similarity.PCCSimilarity;
import net.librec.similarity.RecommenderSimilarity;
// Copyright (C) 2014 Guibing Guo
//
// This file is part of LibRec.
//
// LibRec is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// LibRec is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with LibRec. If not, see <http://www.gnu.org/licenses/>.
//


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length==1) {
            List<RecommendedItem> recommendedItemList = Recomendator.getInstance().recomend(args[0]);
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
        }
        else{
             if (args.length==5){
                 CSVWriter writer=new CSVWriter();
                 String saltoDeLinea=System.getProperty("line.separator");
                 String lineaCSV= args[0]+","+args[1]+","+args[2]+","+args[3]+","+args[4]+saltoDeLinea;
                 writer.write(lineaCSV,"data/arff/rating/RecosDeOtros.csv");

             }
             else{
                 System.out.printf("Error en los parametros");
             }

        }




    }

}
