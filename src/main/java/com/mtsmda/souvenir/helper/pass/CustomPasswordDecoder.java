package com.mtsmda.souvenir.helper.pass;

import com.mtsmda.souvenir.helper.ListHelper;
import com.mtsmda.souvenir.helper.SetHelper;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Created by dminzat on 7/1/2016.
 */
public class CustomPasswordDecoder {

    private static Map<Integer, List<Character>> mapCharactersWithIndexPhone = new LinkedHashMap<>();

    private List<Character> characters = new ArrayList<>();

    {
        Set<Character> temp = new HashSet<>();
        initCharters(temp, 33, 126);
        initCharters(temp, 130, 140);
        initCharters(temp, 145, 148);
        initCharters(temp, 150, 156);
        initCharters(temp, 161, 191);
        initCharters(temp, 697, 740);
        SetHelper.convertSetToList(temp, characters);
    }

    private void initCharters(Set<Character> characters, final int start, int end) {
        for (int i = start; i <= end; i++) {
            characters.add((char) i);
        }
    }

    public void initPhone() {
        mapCharactersWithIndexPhone.put(2, Arrays.asList('a', 'b', 'c'));
        mapCharactersWithIndexPhone.put(3, Arrays.asList('d', 'e', 'f'));
        mapCharactersWithIndexPhone.put(4, Arrays.asList('g', 'h', 'i'));
        mapCharactersWithIndexPhone.put(5, Arrays.asList('j', 'k', 'l'));
        mapCharactersWithIndexPhone.put(6, Arrays.asList('m', 'n', 'o'));
        mapCharactersWithIndexPhone.put(7, Arrays.asList('p', 'q', 'r', 's'));
        mapCharactersWithIndexPhone.put(8, Arrays.asList('t', 'u', 'v'));
        mapCharactersWithIndexPhone.put(9, Arrays.asList('w', 'x', 'y', 'z'));
    }

    public String encode(PasswordType passwordType, ShiftType shiftType, int shift, String text) {
        StringBuilder result = new StringBuilder();
        switch (passwordType) {
            case PHONE_TYPE: {

            }
            break;
            case SHIFT_TYPE: {
                switch (shiftType) {
                    case CUSTOM_SHIFT: {

                    }
                    break;
                    case DEFAULT_SHIFT: {
                        int localShift = 9;
                        if (StringUtils.isNotBlank(text)) {
                            for (int i = 0; i < text.length(); i++) {
                                int currentShift = text.charAt(i) + localShift;
                                /*if(currentShift > characters.size()){

                                }else{*/
                                    result.append(characters.get(currentShift));
//                                }

                            }
                            result.append("ST_DF__");
                        }
                    }
                    break;
                    case RANDOM_SHIFT: {
                    }
                    break;
                }
            }
            break;
        }
        return result.toString();
    }

    public String decode(String text) {
        StringBuilder result = new StringBuilder();
        if(StringUtils.isNotBlank(text) && text.length() > 7){
            String type = text.substring(text.length() - 7);
            String original = text.substring(0, text.length() - 7);
            System.out.println("type\t" + type);
            System.out.println("original\t" + original);
            int localShift = 9;
            for(int i = 0; i < original.length(); i++){
                char currentChar = original.charAt(i);
                char currentCharWithShift = (char) (currentChar - localShift);
                int indexByObject = ListHelper.getIndexByObject(characters, currentCharWithShift);
                result.append(characters.get(indexByObject));
//                result.append(characters.get(ListHelper.getIndexByObject(characters, ((char)(original.charAt(i) - 9)))));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        /*char c = 90;
        System.out.println(c);*/
        /*for (int i = 0; i < 1_000; i++) {
            System.out.println(i + " = " + (char) i);
        }*/
        CustomPasswordDecoder customPasswordDecoder = new CustomPasswordDecoder();
        String encode = customPasswordDecoder.encode(PasswordType.SHIFT_TYPE, ShiftType.DEFAULT_SHIFT, -1, "Dima");
        System.out.println("encode = " + encode);
        String decode = customPasswordDecoder.decode(encode);
        System.out.println(decode);
    }



}