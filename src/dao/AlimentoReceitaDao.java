package dao;

import classes.AlimentoReceita;
import java.util.Objects;
import static utils.Utils.*;

public class AlimentoReceitaDao {
    private AlimentoReceita[] alimentore = new AlimentoReceita[100];

    public AlimentoReceita[] getAlimentore(){
        return alimentore;
    }

    public AlimentoReceita getRecipeByIDFood(int id){
        for (int i = 0; i < alimentore.length; i++) {
            if (alimentore[i] == null){
                break;
            }
            if (alimentore[i].getId() == id){
                return alimentore[i];
            }
        }
        return null;
    }
    public AlimentoReceita searchNameFood(String nome){
        for(int i = 0; i < alimentore.length; i++){
            if(alimentore[i] != null && Objects.equals(alimentore[i].getNome(), nome)){
                return alimentore[i];
            }
        }
        return null;
    }

    public void addAlPe(AlimentoReceita recipes){
        int id = findEmptyPosition(alimentore);
        if (id != -1) {
            alimentore[id] = recipes;
        }
    }

    public boolean deleteRecipe(String nm){
        for (int i = 0; i < alimentore.length; i++) {
            if (alimentore[i] != null && Objects.equals(String.valueOf(alimentore[i].getNome()), nm)){
                alimentore[i] = null;
                rearrangeArray(alimentore);
                return true;
            }
        }
        return false;
    }
}
