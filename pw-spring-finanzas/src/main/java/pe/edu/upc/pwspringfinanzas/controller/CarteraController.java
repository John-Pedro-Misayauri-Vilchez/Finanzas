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

import pe.edu.upc.pwspringfinanzas.model.entity.Cartera;
import pe.edu.upc.pwspringfinanzas.service.crud.CarteraService;
import pe.edu.upc.pwspringfinanzas.model.entity.TipoDescuento;
import pe.edu.upc.pwspringfinanzas.model.entity.TipoMoneda;
import pe.edu.upc.pwspringfinanzas.model.entity.TipoTasa;
import pe.edu.upc.pwspringfinanzas.model.entity.Cliente;
import pe.edu.upc.pwspringfinanzas.model.entity.PlazoTasa;

import pe.edu.upc.pwspringfinanzas.service.crud.ClienteService;
import pe.edu.upc.pwspringfinanzas.service.crud.PlazoTasaService;
import pe.edu.upc.pwspringfinanzas.service.crud.TipoDescuentoService;
import pe.edu.upc.pwspringfinanzas.service.crud.TipoMonedaService;
import pe.edu.upc.pwspringfinanzas.service.crud.TipoTasaService;



@Controller
@RequestMapping("/carteras")
@SessionAttributes("carteraEdit")
public class CarteraController {

	@Autowired
	private CarteraService carteraService;

	@Autowired
	private TipoDescuentoService tipoDescuentoService;
	
	@Autowired
	private TipoMonedaService tipoMonedaService;
	
	@Autowired
	private TipoTasaService tipoTasaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private PlazoTasaService plazoTasaService;

	@GetMapping
	public String list(Model model) {
		try {
			List<Cartera> carteras = carteraService.getAll();
			model.addAttribute("carteras", carteras);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "letra/nuevaletra";
	}

	// Id's
	@GetMapping("{id}/viewCartera") // GET: /studios/{id}
	public String findById(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Cartera> optional = carteraService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("cartera", optional.get());
				return "carteras/viewCartera";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/carteras";
	}

	@GetMapping("{id}/editCartera") // GET: /studios/{id}/edit
	public String findById2(Model model, @PathVariable("id") Integer id) {
		try {
			Optional<Cartera> optional = carteraService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("carteraEdit", optional.get());
				List<TipoMoneda> listTipoMonedas = tipoMonedaService.getAll();
				model.addAttribute("listTipoMonedas", listTipoMonedas);
				List<TipoTasa> listTipoTasas = tipoTasaService.getAll();
				model.addAttribute("listTipoTasas", listTipoTasas);
				List<TipoDescuento> listTipoDescuentos = tipoDescuentoService.getAll();
				model.addAttribute("listTipoDescuentos", listTipoDescuentos);
				List<Cliente> listClientes = clienteService.getAll();
				model.addAttribute("listClientes", listClientes);
				List<PlazoTasa> listPlazoTasas = plazoTasaService.getAll();
				model.addAttribute("listPlazoTasas", listPlazoTasas);
				return "carteras/editCartera";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/carteras";
	}

	@PostMapping("save")
	public String saveEdit(Model model, @ModelAttribute("carteraEdit") Cartera cartera) {
		try {
			Cartera carteraReturn = carteraService.update(cartera);
			model.addAttribute("cartera", carteraReturn);
			// return "studios/viewStudio";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/carteras";
	}

	@GetMapping("new")
	public String newItem(Model model) {
		try {
			Cartera cartera = new Cartera();
			model.addAttribute("carteraNew",cartera);
			List<TipoMoneda> listTipoMonedas = tipoMonedaService.getAll();
			model.addAttribute("listTipoMonedas", listTipoMonedas);
			List<TipoTasa> listTipoTasas = tipoTasaService.getAll();
			model.addAttribute("listTipoTasas", listTipoTasas);
			List<TipoDescuento> listTipoDescuentos = tipoDescuentoService.getAll();
			model.addAttribute("listTipoDescuentos", listTipoDescuentos);
			List<Cliente> listClientes = clienteService.getAll();
			model.addAttribute("listClientes", listClientes);
			List<PlazoTasa> listPlazoTasas = plazoTasaService.getAll();
			model.addAttribute("listPlazoTasas", listPlazoTasas);
			return "carteras/newCartera";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/carteras";
	}

	@PostMapping("savenew")
	public String saveNew(Model model, @ModelAttribute("carteraNew") Cartera cartera) {
		try {
			Cartera carteraReturn = carteraService.create(cartera);
			model.addAttribute("cartera", carteraReturn);
			//return "carteras/viewCartera";
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/carteras";
	}

	@GetMapping("{id}/deleteCartera")
	public String deleteCartera(@PathVariable("id") Integer id) {
		try {
			Optional<Cartera> optional = carteraService.findById(id);
			if (optional.isPresent()) {
				carteraService.deteleById(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/carteras";
	}

}
