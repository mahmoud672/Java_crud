package io.gad.demo.validation.constraint.course;

import org.springframework.beans.factory.annotation.Autowired;

import io.gad.demo.repository.CourseRepository;
import io.gad.demo.validation.annotation.course.CourseIdExists;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseIdExistsConstraint implements ConstraintValidator<CourseIdExists,Integer>{

	@Autowired
	CourseRepository repository;
	
	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		if(value == null)
		{			
//			context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("Course ID cannot be null")
//                   .addConstraintViolation();
            return false;
		}
		if (!repository.existsById(value)) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate("Course with ID " + value + " not found")
//                   .addConstraintViolation();
            return false;
        }
        return true;
	}
	
	

}
