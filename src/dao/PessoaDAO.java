package dao;

import classes.Pessoa;

import static utils.Utils.findEmptyPosition;

public class PessoaDAO {
    private static Pessoa[] users = new Pessoa[10];
    public  void addUsers(Pessoa pessoa){
        int id = findEmptyPosition(users);
        users[id] = pessoa;
    }

    public Pessoa[] getUsers() {
        return users;
    }

    public Pessoa getUserById(int id){
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == id){
                return users[i];
            }
        }
        return null;
    }

}