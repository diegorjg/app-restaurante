package com.yadier.LoExquisitoMar.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yadier.LoExquisitoMar.models.Usuario;
import com.yadier.LoExquisitoMar.services.UsuarioServicio;

@Controller
public class LoginControlador {

	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}

	@GetMapping("")
	public String verPaginaDeInicio(Model modelo) {
		return "index";
	}

	@PostMapping("/login")
	public ModelAndView obtenerCuentaDeUsuario(@ModelAttribute("usuario") Usuario user) {
		ModelAndView model = new ModelAndView();
		if (user.getEmail().equals("admin") && user.getPassword().equals("1234")) {

			model.setViewName("redirect:/");
		} else {
			model.addObject("error", 1);
			model.setViewName("login");
		}
		return model;
	}

}