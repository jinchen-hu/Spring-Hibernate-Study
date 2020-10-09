package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(CourseCode constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
		coursePrefix = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String code, ConstraintValidatorContext context) {

		return code == null || code.toUpperCase().startsWith(coursePrefix);

	}

}
