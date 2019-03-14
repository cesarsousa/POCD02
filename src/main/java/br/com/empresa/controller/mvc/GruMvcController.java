package br.com.empresa.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class GruMvcController {
	@GetMapping("/")
	public String getIndex() {
		return "index";
	}
}
