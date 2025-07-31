package io.gad.demo.validation.annotation.course;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.gad.demo.validation.constraint.course.CourseIdExistsConstraint;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;


@Documented
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = CourseIdExistsConstraint.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseIdExists {
	
	String message() default "course id does n`t exist.";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}

