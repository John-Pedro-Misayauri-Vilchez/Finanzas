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

import pe.edu.upc.pwspringfinanzas.model.entity.TipoDescuento;
import pe.edu.upc.pwspringfinanzas.service.crud.TipoDescuentoService;

@Controller
@RequestMapping("/tipodescuentos")
@SessionAttributes("tipodescuentoEdit")
public class TipoDescuentoController {
	@Autowired
	private TipoDescuentoService tipoDescuentoService;
	
	@GetMapping
	public String list(Model model) {
		try {
			List<TipoDescuento> tipodescuentos = tipoDescuentoService.getAll();
			model.addAttribute("tipodescuentos", tipodescuentos);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "tipodescuentos/listTipoDescuento";
	}
	@PostMapping("save")
	public String saveEdit(Model model, @ModelAttribute("tipodescuentoEdit") TipoDescuento tipodescuento) {
		try {
			TipoDescuento tipodescuentoReturn = tipoDescuentoService.update(tipodescuento);
			model.addAttribute("tipodescuento", tipodescuentoReturn);
			// return "studios/viewStudio";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tipodescuentos";
	}
	@GetMapping("new")
	public String newItem(Model model) {
		try {
			TipoDescuento tipodescuento= new TipoDescuento();
			model.addAttribute("tipodescuentoNew",tipodescuento);
			return "tipodescuentos/newTipoDescuento";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/tipodescuentos";
	}
	@PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("tipodescuentoNew") TipoDescuento tipodescuento) {
		try {
			TipoDescuento tipodescuentoReturn = tipoDescuentoService.create(tipodescuento);
			model.addAttribute("tipodescuento", tipodescuentoReturn);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/tipodescuentos";
	}
	@GetMapping("{id}/deleteTipDescuento")
	public String deleteCartera(@PathVariable("id") Integer id) {
		try {
			Optional<TipoDescuento> optional = tipoDescuentoService.findById(id);
			if (optional.isPresent()) {
				tipoDescuentoService.deteleById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/tipodescuentos";
	}
}
