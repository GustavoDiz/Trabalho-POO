package model;

import model.Pessoa;
import model.RegistroDieta;

import static utils.Utils.*;
public class RegistroDietaDAO {
    private  RegistroDieta[] registerDB = new RegistroDieta[100];

    public  RegistroDieta[] getRegisterDB(){
        return registerDB;
    }

    public RegistroDieta getRegisterByIdDiet(int id){
        for (int i = 0; i < registerDB.length; i++) {
            if (registerDB[i].getId() == id){
                return registerDB[i];
            }
        }
        return null;
    }
    public void addRegister(RegistroDieta registro){
        int index = findEmptyPosition(registerDB);
        registerDB[index] = registro;
    }

    public boolean deleteRegister(int id){
        for (int i = 0; i < registerDB.length; i++) {
            if (registerDB[i].getId() == id){
                registerDB[i] = null;
                rearrangeArray(registerDB);
                return true;
            }
        }
        return false;
    }

    public RegistroDieta getRegisterByUser(Pessoa user) {
        for (int i = 0; i < registerDB.length; i++) {
            if (registerDB[i] == null){
                break;
            }
            if (registerDB[i].getUser().equals(user)){
                return registerDB[i];
            }
        }
        return null;
    }
}
