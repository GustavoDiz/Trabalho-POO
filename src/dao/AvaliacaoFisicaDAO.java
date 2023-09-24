package dao;

import classes.AvaliacaoFisica;
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
}
