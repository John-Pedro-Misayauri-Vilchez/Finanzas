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

import pe.edu.upc.pwspringfinanzas.model.entity.TipoMoneda;
import pe.edu.upc.pwspringfinanzas.service.crud.TipoMonedaService;

@Controller
@RequestMapping("/tipomonedas")
@SessionAttributes("tipomonedaEdit")
public class TipoMonedaController {
	@Autowired
	private TipoMonedaService tipoMonedaService;
	
	@GetMapping
	public String list(Model model) {
		try {
			List<TipoMoneda> tipomonedas = tipoMonedaService.getAll();
			model.addAttribute("tipomonedas", tipomonedas);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "tipomonedas/listTipoMoneda";
	}
	@PostMapping("save")
	public String saveEdit(Model model, @ModelAttribute("tipomonedaEdit") TipoMoneda tipomoneda) {
		try {
			TipoMoneda tipomonedaReturn = tipoMonedaService.update(tipomoneda);
			model.addAttribute("tipomoneda", tipomonedaReturn);
			// return "studios/viewStudio";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tipomonedas";
	}
	@GetMapping("new")
	public String newItem(Model model) {
		try {
			TipoMoneda tipomoneda= new TipoMoneda();
			model.addAttribute("tipomonedaNew",tipomoneda);
			return "tipomonedas/newTipoMoneda";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/tipomonedas";
	}
	@PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("tipomonedaNew") TipoMoneda tipomoneda) {
		try {
			TipoMoneda tipomonedaReturn = tipoMonedaService.create(tipomoneda);
			model.addAttribute("tipomoneda", tipomonedaReturn);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/tipomonedas";
	}
	@GetMapping("{id}/deleteTipoMoneda")
	public String deleteCartera(@PathVariable("id") Integer id) {
		try {
			Optional<TipoMoneda> optional = tipoMonedaService.findById(id);
			if (optional.isPresent()) {
				tipoMonedaService.deteleById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tipomonedas";
	}
}
