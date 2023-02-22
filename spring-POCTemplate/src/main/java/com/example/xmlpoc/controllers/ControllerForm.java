package com.example.xmlpoc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerForm {
	
	@GetMapping({"/index","/","",})
	public String index(){
		return "form";
	}
	
    @PostMapping("/form")
    public String nombreApellido(Model model,@RequestParam("xml") String xml, @RequestParam("columnas") String columnas,@RequestParam("filas") String filas) {
    	model.addAttribute("filas",filas);
    	model.addAttribute("columnas",columnas);
    	model.addAttribute("xml",xml);
        return "resultado";
    }
}
