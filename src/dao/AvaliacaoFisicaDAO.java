package dao;

import classes.AvaliacaoFisica;
import classes.Pessoa;

import static utils.Utils.*;

public class AvaliacaoFisicaDAO {
    private AvaliacaoFisica[] physicalDB = new AvaliacaoFisica[100];

    public AvaliacaoFisica[] getPhysicalDB(){
        return  physicalDB;
    }

    public AvaliacaoFisica getPhysicalByID(int id){
        for (int i = 0; i < physicalDB.length; i++) {
            if (physicalDB[i].getId() == id){
                return physicalDB[i];
            }
        }
        return  null;
    }

    public void addPhysical(AvaliacaoFisica avaliacao){
        int index = findEmptyPosition(physicalDB);
        physicalDB[index] = avaliacao;
    }

    public boolean deletePhysical(int id){
        for (int i = 0; i < physicalDB.length; i++) {
            if (physicalDB[i].getId() == id){
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

    public AvaliacaoFisica getPhysicalByUser(Pessoa user){
        AvaliacaoFisica userPhysicals = new AvaliacaoFisica();
        for (int i = 0; i < physicalDB.length; i++) {
            if (physicalDB[i] == null){
                break;
            }
            if (physicalDB[i].getUser().equals(user)){
                return physicalDB[i];
            }
        }
        return null;
    }
}
