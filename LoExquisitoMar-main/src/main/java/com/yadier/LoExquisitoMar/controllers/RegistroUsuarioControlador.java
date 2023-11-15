package com.yadier.LoExquisitoMar.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yadier.LoExquisitoMar.models.Producto;
import com.yadier.LoExquisitoMar.models.Usuario;
import com.yadier.LoExquisitoMar.services.UsuarioServicio;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {
	public ArrayList<String> hasErrors(Usuario user) {
		ArrayList<String> errors = new ArrayList<String>();
		if (user.getNombre().length() < 3) {
			errors.add(Usuario.ERR_NOMBRE);
		}
		if (user.getEmail().isEmpty()) {
			errors.add(Usuario.ERR_EMAIL);
		}
		if (user.getPassword().isEmpty()) {
			errors.add(Usuario.ERR_PASSWORD);
		}
		return errors;
	}

	@GetMapping
	public String mostrarFormularioDeRegistro(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "registro";
	}

	@PostMapping
	public ModelAndView registrarCuentaDeUsuario(@ModelAttribute("usuario") Usuario user) {
		ArrayList<String> erros = hasErrors(user);
		ModelAndView model = new ModelAndView();
		if (erros.isEmpty()) {
			model.setViewName("redirect:/login");
		} else {
			model.addObject("errors", erros);
			model.setViewName("registro");
		}
		return model;
	}
}
