package model;

import model.Pessoa;
import model.Preferencias;

import static utils.Utils.*;

public class PreferenciasDAO {
    private Preferencias[] preferencesDB = new Preferencias[100];
    public  Preferencias[] getPreferencesDB(){
        return  preferencesDB;
    }

    public Preferencias getPreferencesById(int id){
        for (int i = 0; i < preferencesDB.length; i++) {
            if (preferencesDB[i].getId() == id){
                return preferencesDB[i];
            }
        }
        return null;
    }

    public void addDiet(Preferencias preferencias){
        int id = findEmptyPosition(preferencesDB);
        preferencesDB[id] = preferencias;
    }

    public boolean deleteDiet(int id){
        for (int i = 0; i < preferencesDB.length; i++) {
            if (preferencesDB[i].getId() == id){
                preferencesDB[i] = null;
                rearrangeArray(preferencesDB);
                return true;
            }
        }
        return false;
    }

    public Preferencias[] getPreferencesByUser(Pessoa user){
        Preferencias[] userPreferences = new Preferencias[10];
        for (int i = 0; i < preferencesDB.length; i++) {
            if (preferencesDB[i] == null){
                break;
            }
            if (preferencesDB[i].getUser().equals(user)){
                userPreferences[i] = preferencesDB[i];
            }
        }
        return userPreferences;
    }

    public AlimentoReceita[] getFoodsPreferencesByUser(Pessoa user){
        AlimentoReceita[] userPreferences = new AlimentoReceita[10];
        for (int i = 0; i < preferencesDB.length; i++) {
            if (preferencesDB[i] == null){
                break;
            }
            if (preferencesDB[i].getUser().equals(user)){
                userPreferences[i] = preferencesDB[i].getFood();
            }
        }
        return userPreferences;
    }
}
