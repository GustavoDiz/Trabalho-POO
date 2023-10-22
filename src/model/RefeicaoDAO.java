package model;

import model.Pessoa;
import model.Refeicao;
import static utils.Utils.*;
public class RefeicaoDAO {
    private Refeicao[] mealDB = new Refeicao[100];

    public Refeicao[] getMealDb() {
        return mealDB;
    }

    public Refeicao getMealById(int id){
        for (int i = 0; i < mealDB.length; i++) {
            if (mealDB[i].getId() == id){
                return mealDB[i];
            }
        }
        return null;
    }

    public void addMeal(Refeicao refeicao){
        int index = findEmptyPosition(mealDB);
        mealDB[index] = refeicao;
    }

    public boolean deleteMeal(int id){
        for (int i = 0; i < mealDB.length; i++) {
            if (mealDB[i].getId() == id){
                mealDB[i] = null;
                rearrangeArray(mealDB);
                return true;
            }
        }
        return false;
    }

    public Refeicao[] getMealsByUser(Pessoa user) {
       Refeicao[] userMeals = new Refeicao[mealDB.length];
       int y = 0;

        for (int i = 0; i < mealDB.length; i++) {
            if (mealDB[i] != null && mealDB[i].getUser().equals(user)){
                userMeals[y++] = mealDB[i];
            }
        }
        userMeals = rearrangeArray(userMeals);
        return userMeals;
    }


}
