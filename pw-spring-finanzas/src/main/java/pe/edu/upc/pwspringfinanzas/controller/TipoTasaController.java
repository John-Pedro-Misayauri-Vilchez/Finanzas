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

import pe.edu.upc.pwspringfinanzas.model.entity.TipoTasa;
import pe.edu.upc.pwspringfinanzas.service.crud.TipoTasaService;

@Controller
@RequestMapping("/tipotasas")
@SessionAttributes("tipotasaEdit")
public class TipoTasaController {
	@Autowired
	private TipoTasaService tipoTasaService;
	
	@GetMapping
	public String list(Model model) {
		try {
			List<TipoTasa> tipotasas = tipoTasaService.getAll();
			model.addAttribute("tipotasas", tipotasas);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "tipotasas/listTipoTasa";
	}
	@PostMapping("save")
	public String saveEdit(Model model, @ModelAttribute("tipotasaEdit") TipoTasa tipotasa) {
		try {
			TipoTasa tipotasaReturn = tipoTasaService.update(tipotasa);
			model.addAttribute("tipotasa", tipotasaReturn);
			// return "studios/viewStudio";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tipotasas";
	}
	@GetMapping("new")
	public String newItem(Model model) {
		try {
			TipoTasa tipotasa= new TipoTasa();
			model.addAttribute("tipotasaNew",tipotasa);
			return "tipotasas/newTipoTasa";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/tipotasas";
	}
	@PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("tipotasaNew") TipoTasa tipotasa) {
		try {
			TipoTasa tipotasaReturn = tipoTasaService.create(tipotasa);
			model.addAttribute("tipotasa", tipotasaReturn);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/tipotasas";
	}
	@GetMapping("{id}/deleteTipoTasa")
	public String deleteCartera(@PathVariable("id") Integer id) {
		try {
			Optional<TipoTasa> optional = tipoTasaService.findById(id);
			if (optional.isPresent()) {
				tipoTasaService.deteleById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tipotasas";
	}
}
