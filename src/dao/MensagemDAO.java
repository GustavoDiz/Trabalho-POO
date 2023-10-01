package dao;

import classes.Mensagem;
import static utils.Utils.*;
public class MensagemDAO {
    private Mensagem[] messagesDB = new Mensagem[100];

    public Mensagem[] getMessagesDB(){
        return messagesDB;
    }

    public Mensagem getMessageById(String id){
        for (int i = 0; i < messagesDB.length; i++) {
            if (messagesDB[i].getId().equals(id)){
                return messagesDB[i];
            }
        }
        return null;
    }

    public void addMessage(Mensagem msg){
        int index = findEmptyPosition(messagesDB);
        messagesDB[index] = msg;
    }

    public boolean deleteMessage(String id){
        for (int i = 0; i < messagesDB.length; i++) {
            if (messagesDB[i].getId().equals(id)){
                messagesDB[i] = null;
                rearrangeArray(messagesDB);
                return true;
            }
        }
        return false;
    }

    public Mensagem[] getMessagesByUser(String name){
        Mensagem[] msgs = new Mensagem[10];
        for (int i = 0; i < messagesDB.length; i++) {
            if(messagesDB[i] == null){
                break;
            }
            if (messagesDB[i].getRecipient().getNome().equals(name)){
                msgs[i] = messagesDB[i];
            }
        }
        return msgs;
    }
}
