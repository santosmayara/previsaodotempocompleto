package br.usjt.hellospringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.usjt.hellospringboot.model.Tempo;
import br.usjt.hellospringboot.repository.TempoRepository;

@Controller
public class TempoController {
	@Autowired
	private TempoRepository tempPrev;

	@GetMapping ("/tempo")
	public ModelAndView listarDados () {
		//passe o nome da página ao construtor
		ModelAndView mv = new ModelAndView ("previsao_de_tempo");
		//Busque a coleção com o repositório
		List <Tempo> temporal = tempPrev.findAll();
		//adicione a coleção ao objeto ModelAndView
		mv.addObject("tempos", temporal);
		mv.addObject(new Tempo());
		//devolva o ModelAndView
		return mv;
	}

	@PostMapping
	public String salvar (Tempo temp) {
		tempPrev.save(temp);
		return "redirect:/tempo";
	}
}