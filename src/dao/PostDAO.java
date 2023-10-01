package dao;

import classes.Mensagem;
import classes.Post;

import java.util.Arrays;

import static utils.Utils.*;

import dao.SeguirDAO;
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

    public Post[] getPostByUser(String name) {
        Post[] userPosts = new Post[postsDB.length];
        int y = 0;

        for (int i = 0; i < postsDB.length; i++) {
            if (postsDB[i] != null && postsDB[i].getUser().getNome().equals(name)) {
                userPosts[y++] = postsDB[i];
            }
        }
        return Arrays.copyOf(userPosts, y);
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
