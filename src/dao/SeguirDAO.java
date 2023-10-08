package dao;

import classes.Pessoa;
import classes.Post;
import classes.Seguir;

import java.util.Arrays;

import static utils.Utils.*;

public class SeguirDAO {
    private Seguir[] followsDB = new Seguir[100];

    public Seguir[] getFollowsDB() {
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
            SeguirDAO seguirDAO = new SeguirDAO();
            Seguir[] follows = seguirDAO.getFollowsDB();
            Pessoa[] followedUsers = new Pessoa[follows.length];
            int followedIndex = 0;

            for (Seguir seguir : follows) {
                if (seguir != null && seguir.getFollower().equals(user)) {
                    followedUsers[followedIndex++] = seguir.getFollowed();
                }
            }

            return Arrays.copyOf(followedUsers, followedIndex);
    }

}
