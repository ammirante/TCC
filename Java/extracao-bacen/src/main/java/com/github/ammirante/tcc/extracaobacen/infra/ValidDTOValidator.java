/**
 * 
 */
package com.github.ammirante.tcc.extracaobacen.infra;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * ValidDTOValidator
 *
 */
public class ValidDTOValidator implements ConstraintValidator<ValidDTO, DTO> {
	
	/**
	 *
	 */
	@Override
	public void initialize(ValidDTO constraintAnnotation) {
		
	}

	/**
	 *
	 */
	@Override
	public boolean isValid(DTO dto, ConstraintValidatorContext contraintValidatorContext) {
		return dto.isValid(contraintValidatorContext);
	}

}
