package com.mtsmda.souvenir.spring.validation.validators.constraints;

import com.mtsmda.souvenir.spring.validation.validators.IfNotNullValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by dminzat on 6/14/2016.
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IfNotNullValidator.class})
@Inherited
public @interface IfNotNullConstraint {

    String message() default "{com.mtsmda.souvenir.spring.validation.validators.constraints.IfNotNullConstraint.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    int min() default 0;

    int max() default Integer.MAX_VALUE;

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        IfNotNullConstraint[] value();
    }

}