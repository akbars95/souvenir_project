package com.mtsmda.souvenir.helper;

import java.util.List;
import java.util.Set;

/**
 * Created by dminzat on 7/4/2016.
 */
public class SetHelper {

    public static<T> void convertSetToList(Set<T> tSet, List<T> tList){
        if(tSet != null && tList != null){
            tSet.forEach(e -> {
                tList.add(e);
            });
        }
    }

}