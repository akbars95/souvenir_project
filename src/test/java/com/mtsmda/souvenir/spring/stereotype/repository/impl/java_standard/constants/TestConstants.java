package com.mtsmda.souvenir.spring.stereotype.repository.impl.java_standard.constants;

/**
 * Created by dminzat on 3/21/2016.
 */
public class TestConstants {

    public static final String NOT_NULL = "may not be null";
    public static final String SIZE_MIN_3_AND_MAX_50 = getSizeMinMax(3, 50);
    public static final String SIZE_MIN_6_AND_MAX_50 = getSizeMinMax(6, 50);
    public static final String SIZE_MIN_3_AND_MAX_1000 = getSizeMinMax(3, 1000);
    public static final String SIZE_MIN_5_AND_MAX_10 = getSizeMinMax(5, 10);
    public static final String SIZE_MIN_10_AND_MAX_255 = getSizeMinMax(10, 255);
    public static final String SIZE_MIN_3_AND_MAX_255 = getSizeMinMax(3, 255);
    public static final String SIZE_MIN_7_AND_MAX_255 = getSizeMinMax(7, 255);
    public static final String SIZE_MIN_1_AND_MAX_50 = getSizeMinMax(1, 50);
    public static final String SIZE_MIN_2_AND_MAX_50 = getSizeMinMax(2, 50);
    public static final String EMAIL = "not a well-formed email address";
    public static final String MIN_VALUE_1 = getNumericValueMin(1);
    public static final String MAX_VALUE_50 = getNumericValueMax(50);
    public static final String DATE_PAST = "must be in the past";
    public static final String IMAGE_PATH_CONSTRAINT = "must match \"^[/]{1}[\\w\\p{Punct}\\p{Blank}А-Яа-я]*(\\.(?i)(jpg|png|gif|bmp|jpeg))$\"";
    public static final String DIGITS_CONSTRAINT_5_4 = getDigits(5, 4);


    public static final String getSizeMinMax(int min, int max) {
        return "size must be between " + min + " and " + max;
    }

    public static final String getNumericValueMin(int integer) {
        return "must be greater than or equal to " + integer;
    }

    public static final String getNumericValueMax(int integer) {
        return "must be less than or equal to " + integer;
    }

    public static final String getDigits(int integer, int fraction) {
        return "numeric value out of bounds (<" + integer + " digits>.<" + fraction + " digits> expected)";
    }

}