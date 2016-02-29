package com.mtsmda.souvenir.helper;


import com.mtsmda.souvenir.exception.SouvenirRuntimeException;

import java.util.List;
import java.util.Map;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
public class MapHelper {

    public static <K, V> void getMap(Map<K, V> tvMap, List<K> listKeys, V... values) {
        if (listKeys.size() != values.length) {
            throw new SouvenirRuntimeException("Count keys not equals count values!");
        }
        for (int i = 0; i < listKeys.size(); i++) {
            tvMap.put(listKeys.get(i), values[i]);
        }
    }

}