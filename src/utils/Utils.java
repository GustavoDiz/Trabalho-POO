package utils;

import classes.Pessoa;

import java.lang.reflect.Array;

public class Utils {
    public static <T> int  findEmptyPosition(T[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null){
                return i;
            }
        }
        return -1;
    }
}
