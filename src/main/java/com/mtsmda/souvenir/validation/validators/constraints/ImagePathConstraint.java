package com.mtsmda.souvenir.validation.validators.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by dminzat on 5/12/2016.
 */
@Pattern(regexp = "^[/]{1}[\\w\\p{Punct}\\p{Blank}А-Яа-я]*(\\.(?i)(jpg|png|gif|bmp|jpeg))$")
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { })
@Inherited
public @interface ImagePathConstraint {

    String message() default "{com.mtsmda.souvenir.validation.validators.constraints.ImagePathConstraint.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ImagePathConstraint[] value();
    }

}