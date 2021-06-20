package pe.edu.upc.pwspringfinanzas.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upc.pwspringfinanzas.model.entity.TipoPersona;
import pe.edu.upc.pwspringfinanzas.service.crud.TipoPersonaService;

@Controller
@RequestMapping("/tipopersonas")
@SessionAttributes("tipopersonaEdit")
public class TipoPersonaController {
	@Autowired
	private TipoPersonaService tipoPersonaService;
	
	@GetMapping
	public String list(Model model) {
		try {
			List<TipoPersona> tipopersonas = tipoPersonaService.getAll();
			model.addAttribute("tipopersonas", tipopersonas);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "tipopersonas/listTipoPersona";
	}
	@PostMapping("save")
	public String saveEdit(Model model, @ModelAttribute("tipopersonaEdit") TipoPersona tipopersona) {
		try {
			TipoPersona tipopersonaReturn = tipoPersonaService.update(tipopersona);
			model.addAttribute("tipopersona", tipopersonaReturn);
			// return "studios/viewStudio";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tipopersonas";
	}
	@GetMapping("new")
	public String newItem(Model model) {
		try {
			TipoPersona tipopersona= new TipoPersona();
			model.addAttribute("tipopersonaNew",tipopersona);
			return "tipopersonas/newTipoPersona";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/tipopersonas";
	}
	@PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("tipopersonaNew") TipoPersona tipopersona) {
		try {
			TipoPersona tipopersonaReturn = tipoPersonaService.create(tipopersona);
			model.addAttribute("tipopersona", tipopersonaReturn);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/tipopersonas";
	}
	@GetMapping("{id}/deleteTipoPersona")
	public String deleteCartera(@PathVariable("id") Integer id) {
		try {
			Optional<TipoPersona> optional = tipoPersonaService.findById(id);
			if (optional.isPresent()) {
				tipoPersonaService.deteleById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tipopersonas";
	}
}
