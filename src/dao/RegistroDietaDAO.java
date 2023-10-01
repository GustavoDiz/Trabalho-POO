package dao;

import classes.AlimentoReceita;
import classes.RegistroDieta;

import java.util.Objects;

import static utils.Utils.*;
public class RegistroDietaDAO {
    private  RegistroDieta[] registerDB = new RegistroDieta[100];

    public  RegistroDieta[] getRegisterDB(){
        return registerDB;
    }

    public RegistroDieta getRegisterByIdDiet(String id){
        for (int i = 0; i < registerDB.length; i++) {
            if (registerDB[i].getId().equals(id)){
                return registerDB[i];
            }
        }
        return null;
    }
    public void addRegister(RegistroDieta registro){
        int index = findEmptyPosition(registerDB);
        registerDB[index] = registro;
    }

    public boolean deleteRegister(String id){
        for (int i = 0; i < registerDB.length; i++) {
            if (registerDB[i].getId().equals(id)){
                registerDB[i] = null;
                rearrangeArray(registerDB);
                return true;
            }
        }
        return false;
    }

}
