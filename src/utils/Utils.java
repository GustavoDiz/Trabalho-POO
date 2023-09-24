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

    public static  <T> T[] rearrangeArray(T[] array){
        int qtNotNull = 0;

        for(T element : array){
            if (element != null){
                qtNotNull ++;
            }
        }

        T[] newArray = (T[]) new Object[qtNotNull];
        int indexNewArray = 0;

        for (T element : array){
            if (element != null){
                newArray[indexNewArray++] = element;
            }
        }

       return  newArray;
    }

}