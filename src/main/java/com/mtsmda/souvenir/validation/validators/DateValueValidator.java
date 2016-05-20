package com.mtsmda.souvenir.validation.validators;

import com.mtsmda.souvenir.validation.validators.constraints.DateValueConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by dminzat on 5/12/2016.
 */
public class DateValueValidator implements ConstraintValidator<DateValueConstraint, Object> {
    @Override
    public void initialize(DateValueConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object localDate, ConstraintValidatorContext context) {
        try{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy", Locale.GERMAN);
            LocalDate innerLocalDate = LocalDate.parse(localDate.toString(), dateTimeFormatter);
            System.out.println(innerLocalDate.format(dateTimeFormatter));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
