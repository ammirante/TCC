/**
 * 
 */
package com.github.ammirante.tcc.extracaobacen.infra;

import javax.validation.ConstraintValidatorContext;

/**
 * DTO
 *
 */
public interface DTO {

	/**
	 * @param contraintValidaorContext
	 * @return
	 */
	default Boolean isValid(ConstraintValidatorContext  contraintValidaorContext) {
		return Boolean.TRUE;
	}
}
