package model;

import model.Pessoa;
import model.Seguir;

import static utils.Utils.*;

public class SeguirDAO {
    private Seguir[] followsDB = new Seguir[100];

    public Seguir[] getFollowsDB() {
        return followsDB;
    }


    public Seguir getFollowByID(int id) {
        for (int i = 0; i < followsDB.length; i++) {
            if (followsDB[i].getId() == id) {
                return followsDB[i];
            }
        }
        return null;
    }

    public void addFollow(Seguir seguir) {
        int index = findEmptyPosition(followsDB);
        followsDB[index] = seguir;
    }

    public boolean deleteFollow(int id) {
        for (int i = 0; i < followsDB.length; i++) {
            if (followsDB[i].getId() == id) {
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

    public Pessoa[] getFollowers(Pessoa user) {
        Pessoa[] followers = new Pessoa[10];
        for (int i = 0; i < followsDB.length; i++) {
            if (followsDB[i] == null) {
                break;
            }
            if (followsDB[i].getFollower().equals(user)) {
                followers[i] = followsDB[i].getFollowed();
            }
        }
        followers = rearrangeArray(followers);
        return followers;
    }
}
