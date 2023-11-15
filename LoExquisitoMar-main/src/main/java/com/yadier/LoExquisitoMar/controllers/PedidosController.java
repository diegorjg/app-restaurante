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
@RequestMapping("/pedidos")
public class PedidosController {

	@GetMapping
	public String reserva(Model model) {
		model.addAttribute("pedidos", new Reserva());
		return Paginas.PEDIDOS;
	}

}
