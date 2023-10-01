package dao;

import classes.AlimentoRefeicao;
import static utils.Utils.*;
public class AlimentoRefeicaoDAO {
    private AlimentoRefeicao[] mealfoodDB = new AlimentoRefeicao[100];
    public  AlimentoRefeicao[] getMealfoodDB(){
        return mealfoodDB;
    }

    public  AlimentoRefeicao getMealFoodById(String id){
        for (int i = 0; i < mealfoodDB.length; i++) {
            if (mealfoodDB[i].getId().equals(id)){
                return mealfoodDB[i];
            }
        }
        return null;
    }

    public void addMealFood(AlimentoRefeicao mealfood){
        int index =findEmptyPosition(mealfoodDB);
        mealfoodDB[index] = mealfood;
    }

    public boolean deleteMealFood(String id){
        for (int i = 0; i < mealfoodDB.length; i++) {
            if (mealfoodDB[i].getId().equals(id)){
                mealfoodDB[i] = null;
                rearrangeArray(mealfoodDB);
                return true;
            }
        }
        return false;
    }

}
