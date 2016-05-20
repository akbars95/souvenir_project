package com.mtsmda.souvenir.tests;

import com.mtsmda.souvenir.validation.validators.constraints.DateValueConstraint;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * Created by dminzat on 5/12/2016.
 */
public class Java8Date {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2016, Month.FEBRUARY, 5);
        /*System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getMonth().getValue());
        System.out.println(localDate.getYear());
*/
        System.out.println(localDate.toString());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate dateTime = LocalDate.parse((localDate.getDayOfMonth() < 10 ? "0" : "") + localDate.getDayOfMonth() + "." + (localDate.getMonth().getValue() < 10 ? "0" : "") + localDate.getMonth().getValue() + "." + localDate.getYear(), formatter);
        dateTime.format(formatter);
        System.out.println(dateTime.toString());

        SimpleJava8DateDemo simpleJava8DateDemo = new SimpleJava8DateDemo();
        simpleJava8DateDemo.setLocalDate("25.02.2019");

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<SimpleJava8DateDemo>> validate = validator.validate(simpleJava8DateDemo);
        System.out.println(validate.size());
    }

}

class SimpleJava8DateDemo{

    @DateValueConstraint
    private String localDate;

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }
}