package com.gaiagalhardo.irere.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gaiagalhardo.irere.model.Produto;

@Controller
public class ProdutosController {

	@RequestMapping("/produtos/novo")
	public String novo(Model model) {
		model.addAttribute(new Produto());
		//return "produto/CadastroProduto";
		return "usuario/CadastroUsuario";
	}

	@RequestMapping(value = "/produtos/novo", method = RequestMethod.POST)
	public String cadastrar(@Valid Produto produto, BindingResult result, Model model, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			//return "produto/CadastroProduto";
			return "usuario/CadastroUsuario";
		}
		
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso.");
		return "redirect:/produtos/novo";
	}

}
