package org.eclipse.jakarta.hello.entities;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

// interface takes an annotation and class to validate
public class ValidEmployeeCheck implements ConstraintValidator<ValidEmployee, Employee> {

    @Override
    public void initialize(ValidEmployee constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Employee employee, ConstraintValidatorContext constraintValidatorContext) {
        return employee.getFirstName().startsWith("The");
    }
}
