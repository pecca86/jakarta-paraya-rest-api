package org.eclipse.jakarta.hello.entities;

import jakarta.validation.Constraint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ElementType.TYPE_USE}) // annotation is a class annotation
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME) // compiler needs to store annotation in the .class file
@Documented
@Constraint(validatedBy = {ValidEmployeeCheck.class}) // specify which class is responsible for the validation
public @interface ValidEmployee {

    // these three methods needs ALWAYS to be implemented!
    String message() default "Invalid employee";

    // define is a certain check is part of a group if this validation should only apply for a certain group. Empty = always perform validation.
    Class<?>[] groups() default {};

    //
    Class<? extends jakarta.validation.Payload>[] payload() default {};

}
