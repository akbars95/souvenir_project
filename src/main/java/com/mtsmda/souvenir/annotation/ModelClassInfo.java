package com.mtsmda.souvenir.annotation;

import java.lang.annotation.*;

/**
 * Created by c-DMITMINZ on 29.01.2016.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ModelClassInfo {

    public String tableName() default "";
    public String[] tableTriggers() default {};
    public String[] tableStoredProcedures() default {};


}