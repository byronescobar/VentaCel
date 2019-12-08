package com.parcial2.controladores;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.parcial2.entidades.Marca;
import com.parcial2.repositorios.RepoMarca;

@Controller
@RequestMapping(value="marca")
public class MarcaController {

	@Autowired
	RepoMarca repoMarca;
	
	@GetMapping(value="/registroM")   //Nuevo
	public String formumario(Model model) {
		model.addAttribute("marca", repoMarca.findAll());
		return "/marca";
	}
	
	@PostMapping(value = "/registrarM")  //Add
	public String registrarP(@Valid @ModelAttribute("marca") Marca marca, RedirectAttributes flash) {
			if(marca.getId()>0) {
				flash.addFlashAttribute("warning","exito, marca actualizada!");
			}else {
				flash.addFlashAttribute("exito","exito, marca guardada");
			}
			repoMarca.save(marca);
		return "redirect:/producto/registroP";
	}
}
