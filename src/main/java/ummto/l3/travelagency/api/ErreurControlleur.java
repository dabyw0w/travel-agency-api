package ummto.l3.travelagency.api;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ummto.l3.travelagency.objetretour.ErreurGenerique;

/**
 * classe d'interception des exception afin de reformater l'erreur dans un
 * message générique
 * 
 * @author djebarri
 *
 */
@RestControllerAdvice
public class ErreurControlleur {

	@ExceptionHandler(ValidationException.class)
	public ErreurGenerique ErreurGenerique(ValidationException e, HttpServletResponse res) {
		ErreurGenerique err = new ErreurGenerique();
		err.setId(e.getId());
		res.setStatus(e.getHttpCode());
		err.setDescription(e.getDesc());
		return err;
	}

}
