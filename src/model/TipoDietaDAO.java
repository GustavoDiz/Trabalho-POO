package model;

import model.TipoDieta;
import static utils.Utils.*;

public class TipoDietaDAO {
    private TipoDieta[] dietsDB = new TipoDieta[100];

    public TipoDieta[] getDietsDB(){
        return  dietsDB;
    }

    public  TipoDieta getDietByID(int id){
        for (int i = 0; i < dietsDB.length; i++) {
            if (dietsDB[i].getId() == id ){
                return dietsDB[i];
            }
        }
        return null;
    }

    public void addDiet(TipoDieta dieta){
        int id = findEmptyPosition(dietsDB);
        dietsDB[id] = dieta;
    }

    public boolean deleteDiet(int id){
        for (int i = 0; i < dietsDB.length; i++) {
            if (dietsDB[i].getId() == id){
                dietsDB[i] = null;
                rearrangeArray(dietsDB);
                return true;
            }
        }
        return false;
    }

    public TipoDieta getDietByName(String dietTypeName) {
        for (int i = 0; i < dietsDB.length; i++) {
            if (dietsDB[i].getNome().equals(dietTypeName)){
                return dietsDB[i];
            }
        }
        return null;
    }
}
