package com.yadier.LoExquisitoMar.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yadier.LoExquisitoMar.configuration.Paginas;
import com.yadier.LoExquisitoMar.models.Reserva;
import com.yadier.LoExquisitoMar.models.Usuario;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	public ArrayList<String> hasErrors(Reserva reserva) {
		ArrayList<String> errors = new ArrayList<String>();
		Date fechaactual = new Date(System.currentTimeMillis());
		// comprueba si es que inicio esta después que fecha actual
		if (!reserva.getFecha().after(fechaactual)) {
			System.out.println("error Reserva fecha ");
			errors.add(Reserva.ERR_FECHA);
		}
		if (reserva.getHora().isEmpty()) {
			errors.add(Reserva.ERR_HORA);
		}

		if (reserva.getNumPersonas() < 1) {
			errors.add(Reserva.ERR_NUMPERSONAS);
		}
		if (reserva.getMesa() < 1) {
			errors.add(Reserva.ERR_MESA);
		}
		return errors;
	}

	@GetMapping
	public String reserva(Model model) {
		model.addAttribute("reserva", new Reserva());
		return Paginas.RESERVA;
	}

	@PostMapping
	public ModelAndView registrarReserva(@ModelAttribute("reserva") Reserva reserva) {
		
		
		ModelAndView model = new ModelAndView();
		try {
		ArrayList<String> erros = hasErrors(reserva);
		System.out.println("Hora "+ reserva.getHora());
		if (erros.isEmpty()) {
			model.setViewName("redirect:/");
		} else {
			model.addObject("errors", erros);
			model.setViewName(Paginas.RESERVA);
		}
		
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return model;
	}

}
