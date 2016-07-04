package com.mtsmda.souvenir.helper;

import java.util.List;
import java.util.Set;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
public class ListHelper {

    public static <T> void getList(List<T> tList, T... ts) {
        for (int i = 0; i < ts.length; i++) {
            tList.add(ts[i]);
        }
    }

    public static <T extends Object>int getIndexByObject(List<T> tList, T ob){
        for(int i = 0; i < tList.size(); i++){
            if(tList.get(i).equals(ob)){
                return i;
            }
        }
        return -1;
    }

    public static<T> void convertListToSet(List<T> tList, Set<T> tSet){
        if(tSet != null && tList != null){
            tList.forEach(e -> {
                tSet.add(e);
            });
        }
    }

}