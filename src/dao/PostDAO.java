package dao;

import classes.Pessoa;
import classes.Post;

import java.util.Arrays;

import static utils.Utils.*;

public class PostDAO {
    private Post[] postsDB = new Post[500];

    public Post[] getPostsDB(){
        return postsDB;
    }

    public  Post getPostById(int id){
        for (int i = 0; i < postsDB.length; i++) {
            if (postsDB[i].getId() == id){
                return postsDB[i];
            }
        }
        return null;
    }
    public void addPost(Post post){
        int index = findEmptyPosition(postsDB);
        postsDB[index] = post;
    }

    public Post[] getPostByUser(Pessoa user) {
        Post[] userPosts = new Post[postsDB.length];
        int y = 0;

        for (int i = 0; i < postsDB.length; i++) {
            if (postsDB[i] != null && postsDB[i].getUser().equals(user)) {
                userPosts[y++] = postsDB[i];
            }
        }
        userPosts = rearrangeArray(userPosts);
        return userPosts;
    }

    public boolean deletePost(int id){
        for (int i = 0; i < postsDB.length; i++) {
            if (postsDB[i].getId() == id){
                postsDB[i] = null;
                rearrangeArray(postsDB);
                return true;
            }
        }
        return false;
    }

    /*public Post[] getPostByFollowers(String[] users){
        Post[] userPosts = new Post[10];
        Post[] usernew = new Post[10];
        userPosts = getPostByFollowers()

        int y = 0;
        for(int i = 0 ; i < 10; i++){

            for(y = 0; y < 10; y++){
                if (postsDB[i] != null && postsDB[i].getUser().getNome().equals()) {
                    usernew[y] = postsDB[i];
                }
            }
        }
        return usernew;
    }*/

}
