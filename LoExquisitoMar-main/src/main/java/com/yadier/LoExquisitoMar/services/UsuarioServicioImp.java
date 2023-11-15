package com.yadier.LoExquisitoMar.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.yadier.LoExquisitoMar.models.Usuario;



public class UsuarioServicioImp implements UsuarioServicio {

	@Override
	public ArrayList<String> hasErrors(Usuario user) {
		ArrayList<String> errors = new ArrayList<String>();
		if(user.getNombre().length() < 3) {
		    errors.add(Usuario.ERR_NOMBRE);
		}
		if(user.getEmail().isEmpty()) {
			 errors.add(Usuario.ERR_EMAIL);
		}
		if(user.getPassword().isEmpty()) {
			 errors.add(Usuario.ERR_PASSWORD);
		}
		
	return errors;
	}

}