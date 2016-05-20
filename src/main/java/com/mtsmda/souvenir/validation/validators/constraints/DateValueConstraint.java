package com.mtsmda.souvenir.validation.validators.constraints;

import com.mtsmda.souvenir.validation.validators.DateValueValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by dminzat on 5/12/2016.
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { DateValueValidator.class})
@Inherited
public @interface DateValueConstraint {

    String message() default "{com.mtsmda.souvenir.validation.validators.constraints.DateValueConstraint.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        DateValueConstraint[] value();
    }

}