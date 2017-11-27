package com.company;

import net.librec.recommender.item.RecommendedItem;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Colo on 19/11/2017.
 */
public class FiltroRecos {
    private final String usuario;
    private final List<RecommendedItem> recomendadosOriginales;

    public FiltroRecos(String usuario, List<RecommendedItem> recommendedItemList) {
        this.usuario=usuario;
        this.recomendadosOriginales=recommendedItemList;
    }

    public List<RecommendedItem> filtrar() {
        int counter=0;
        List<RecommendedItem> nuevosReco=new LinkedList<RecommendedItem>();
        for(RecommendedItem recommendedItem : recomendadosOriginales){
            if (Objects.equals(recommendedItem.getUserId(),usuario.toString())) {
                if (counter > 0 && !Objects.equals(recomendadosOriginales.get(counter - 1).getUserId(),usuario.toString())){
                    nuevosReco.add(recomendadosOriginales.get(counter - 1));
                }
                if (counter+1<recomendadosOriginales.size() && !Objects.equals(recomendadosOriginales.get(counter + 1).getUserId(),usuario.toString())){
                    nuevosReco.add(recomendadosOriginales.get(counter + 1));
                }
            }
            counter++;
        }

        return eliminarRepetidos(nuevosReco);
    }

    private List<RecommendedItem> eliminarRepetidos(List<RecommendedItem> nuevosReco) {
        int tamanio=nuevosReco.size();
        for (int counteri=0;counteri<tamanio;counteri++){
            for (int counterj=0;counterj<tamanio;counterj++){
                if(counteri!=counterj){
                    if(Objects.equals(nuevosReco.get(counteri).getItemId(),nuevosReco.get(counterj).getItemId())) {
                        nuevosReco.remove(counterj);
                        return eliminarRepetidos(nuevosReco);
                    }
                }
            }
        }
        return nuevosReco;
    }

}

