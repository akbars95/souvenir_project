package com.mtsmda.souvenir.validation.validators.constraints;

import com.mtsmda.souvenir.validation.validators.ValuteCodeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by dminzat on 5/17/2016.
 */
@Target({TYPE })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {ValuteCodeValidator.class})
@Inherited
public @interface ValuteCodeConstraint {

    String message() default "{com.mtsmda.souvenir.validation.validators.constraints.ValuteCodeConstraint.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String fieldNameCharCode() default "";

    String fieldNameCode() default "";

    boolean isTest() default false;

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ImagePathConstraint[] value();
    }

}