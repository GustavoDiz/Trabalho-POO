package model;

import model.AlimentoReceita;
import model.AlimentoRefeicao;
import model.Refeicao;

import static utils.Utils.*;
public class AlimentoRefeicaoDAO {
    private AlimentoRefeicao[] mealfoodDB = new AlimentoRefeicao[100];
    public  AlimentoRefeicao[] getMealfoodDB(){
        return mealfoodDB;
    }

    public  AlimentoRefeicao getMealFoodById(int id){
        for (int i = 0; i < mealfoodDB.length; i++) {
            if (mealfoodDB[i].getId() == id){
                return mealfoodDB[i];
            }
        }
        return null;
    }

    public void addMealFood(AlimentoRefeicao mealfood){
        int index =findEmptyPosition(mealfoodDB);
        mealfoodDB[index] = mealfood;
    }

    public boolean deleteMealFood(int id){
        for (int i = 0; i < mealfoodDB.length; i++) {
            if (mealfoodDB[i].getId() == id){
                mealfoodDB[i] = null;
                rearrangeArray(mealfoodDB);
                return true;
            }
        }
        return false;
    }

    public AlimentoReceita[] getFoodsByMeal(Refeicao refeicao){
        AlimentoReceita[] result = new AlimentoReceita[5];
        int y = 0;
        for (int i = 0; i < mealfoodDB.length; i++){
            if (mealfoodDB[i] == null){
                break;
            }
            if (mealfoodDB[i].getMeal().equals(refeicao)){
                result[y++] = mealfoodDB[i].getFood();
            }
        }
        result = rearrangeArray(result);
        return result;
    }
}
