package dao;

import classes.Post;
import static utils.Utils.*;
public class PostDAO {
    private Post[] postsDB = new Post[500];

    public Post[] getPostsDB(){
        return postsDB;
    }

    public  Post getPostById(String id){
        for (int i = 0; i < postsDB.length; i++) {
            if (postsDB[i].getId().equals(id)){
                return postsDB[i];
            }
        }
        return null;
    }

    public void addPost(Post post){
        int index = findEmptyPosition(postsDB);
        postsDB[index] = post;
    }

    public boolean deletePost(String id){
        for (int i = 0; i < postsDB.length; i++) {
            if (postsDB[i].getId().equals(id)){
                postsDB[i] = null;
                rearrangeArray(postsDB);
                return true;
            }
        }
        return false;
    }

}
