package com.yadier.LoExquisitoMar.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yadier.LoExquisitoMar.configuration.Paginas;
import com.yadier.LoExquisitoMar.models.Producto;

@Controller
@RequestMapping("/products")
public class ProductController {

	Producto producto1 = new Producto(1, "Papas fritas 1", 300);
	Producto producto2 = new Producto(2, "Papas fritas 2", 300);
	Producto producto3 = new Producto(3, "Papas fritas 3", 300);

	public List<Producto> getProducts() {
		List<Producto> products = Arrays.asList(producto1, producto2, producto3);
		return products;
	}

	@GetMapping(path = "/")
	public String productos(Model model) {
		model.addAttribute("products", getProducts());
		return "productos";
	}

	@GetMapping(path = { "/{id}" })
	public ModelAndView productoById(@PathVariable(required = true, name = "id") int id) {

		ModelAndView modelView = new ModelAndView(Paginas.PRODUCT);
		Producto product = this.getProducts().stream().filter(p -> {
			return p.getId() == id;
		}).findFirst().orElse(null);

		modelView.addObject("product", product);
		return modelView;

	}

}
