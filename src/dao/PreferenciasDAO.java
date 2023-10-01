package dao;

import classes.Pessoa;
import classes.Preferencias;
import classes.TipoDieta;

import static utils.Utils.*;

public class PreferenciasDAO {
    private Preferencias[] preferencesDB = new Preferencias[100];
    public  Preferencias[] getPreferencesDB(){
        return  preferencesDB;
    }

    public Preferencias getPreferencesById(String id){
        for (int i = 0; i < preferencesDB.length; i++) {
            if (preferencesDB[i].getId().equals(id)){
                return preferencesDB[i];
            }
        }
        return null;
    }

    public void addDiet(Preferencias preferencias){
        int id = findEmptyPosition(preferencesDB);
        preferencesDB[id] = preferencias;
    }

    public boolean deleteDiet(String id){
        for (int i = 0; i < preferencesDB.length; i++) {
            if (preferencesDB[i].getId().equals(id)){
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
}
