package br.com.fiap.cadastrotutor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fiap.cadastrotutor.model.Tutor;
import br.com.fiap.cadastrotutor.repository.TutorRepository;

@Controller
public class TutorController {

	@Autowired
	private TutorRepository repository;
	
	@GetMapping("/tutor")
	public ModelAndView tutores() {
		List<Tutor> tutores = repository.findAll();
		ModelAndView modelAndView = new ModelAndView("tutores");
		modelAndView.addObject("tutores", tutores);
		return modelAndView;
	}
	
	@PostMapping("/tutor")
	public String save(@Valid Tutor tutor, BindingResult result) {
		if (result.hasErrors()) return "tutor-form";
		repository.save(tutor);
		return "tutor-form";
	}
	
	@RequestMapping("/tutor/signup")
	public String create(Tutor tutor) {
		return "tutor-form";
	}
}
