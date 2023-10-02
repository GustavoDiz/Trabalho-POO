package dao;

import classes.Pessoa;
import classes.Seguir;

import java.util.Arrays;

import static utils.Utils.*;

public class SeguirDAO {
    private Seguir[] followsDB = new Seguir[100];

    public Seguir[] getFollowsDB(String nome) {
        return followsDB;
    }


    public Seguir getFollowByID(String id) {
        for (int i = 0; i < followsDB.length; i++) {
            if (followsDB[i].getId().equals(id)) {
                return followsDB[i];
            }
        }
        return null;
    }

    public void addFollow(Seguir seguir) {
        int index = findEmptyPosition(followsDB);
        followsDB[index] = seguir;
    }

    public boolean deleteFollow(String id) {
        for (int i = 0; i < followsDB.length; i++) {
            if (followsDB[i].getId().equals(id)) {
                followsDB[i] = null;
                rearrangeArray(followsDB);
                return true;
            }
        }
        return false;
    }

    public int followers(Pessoa user) {
        int qtFollowers = 0;
        for (int i = 0; i < followsDB.length; i++) {
            if (followsDB[i] == null) {
                break;
            }
            if (followsDB[i].getFollowed().equals(user)) {
                qtFollowers++;
            }
        }
        return qtFollowers;
    }
    public Pessoa[] getFollowers(Pessoa user){
        Pessoa[] follow = new Pessoa[10];
        int followerIndex = 0; // Variável para rastrear a posição no array follow

        for (int i = 0; i < followsDB.length; i++) {
            if (followsDB[i] == null){
                break;
            }
            if (followsDB[i].getFollower().equals(user)){
                follow[followerIndex++] = followsDB[i].getFollower();
            }
        }

        // Certifique-se de retornar um array com o tamanho correto
        return Arrays.copyOf(follow, followerIndex);
    }

}
