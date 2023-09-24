package dao;

import classes.AvaliacaoFisica;
import classes.Pessoa;

import static utils.Utils.*;

public class AvaliacaoFisicaDAO {
    private static AvaliacaoFisica[] physicalDB = new AvaliacaoFisica[100];

    public AvaliacaoFisica[] getPhysicalDB(){
        return  physicalDB;
    }

    public AvaliacaoFisica getPhysicalByID(String id){
        for (int i = 0; i < physicalDB.length; i++) {
            if (physicalDB[i].getId().equals(id)){
                return physicalDB[i];
            }
        }
        return  null;
    }

    public void addPhysical(AvaliacaoFisica avaliacao){
        int index = findEmptyPosition(physicalDB);
        physicalDB[index] = avaliacao;
    }

    public boolean deletePhysical(String id){
        for (int i = 0; i < physicalDB.length; i++) {
            if (physicalDB[i].getId().equals(id)){
                physicalDB[i] = null;
                rearrangeArray(physicalDB);
                return true;
            }
        }
        return false;
    }

    public AvaliacaoFisica[] getPhysicalsByUser(Pessoa user){
        AvaliacaoFisica[] userPhysicals = new AvaliacaoFisica[10];
        for (int i = 0; i < physicalDB.length; i++) {
            if (physicalDB[i] == null){
                break;
            }
            if (physicalDB[i].getUser().equals(user)){
                userPhysicals[i] = physicalDB[i];
            }
        }
        return userPhysicals;
    }
}
