package dao;

import classes.Seguir;
import static utils.Utils.*;

public class SeguirDAO {
    private Seguir[] followsDB = new Seguir[100];

    public Seguir[] getFollowsDB(){
        return followsDB;
    }

    public Seguir getFollowByID(String id){
        for (int i = 0; i < followsDB.length; i++) {
            if (followsDB[i].getId().equals(id)){
                return followsDB[i];
            }
        }
        return null;
    }

    public void addFollow(Seguir seguir){
        int index = findEmptyPosition(followsDB);
        followsDB[index] = seguir;
    }

    public boolean deleteFollow(String id){
        for (int i = 0; i < followsDB.length; i++) {
            if (followsDB[i].getId().equals(id)){
                followsDB[i] = null;
                rearrangeArray(followsDB);
                return true;
            }
        }
        return false;
    }


}
