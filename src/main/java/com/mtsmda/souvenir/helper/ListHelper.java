package com.mtsmda.souvenir.helper;

import java.util.List;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
public class ListHelper {

    public static <T> void getList(List<T> tList, T... ts) {
        for (int i = 0; i < ts.length; i++) {
            tList.add(ts[i]);
        }
    }

}