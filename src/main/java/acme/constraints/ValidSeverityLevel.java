
package acme.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@ReportAsSingleViolation

@Min(0)
@Max(10)

public @interface ValidSeverityLevel {

	// Standard validation properties -----------------------------------------

	String message() default "{acme.validation.severityLevel.message}";

	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
