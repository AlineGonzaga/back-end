package com.banana.comercial.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.banana.comercial.model.Reserva;
import com.banana.comercial.repository.ReservaRepository;

@RestController
@CrossOrigin
public class ReservaController {

	//@Autowired
	private final ReservaRepository reservas;
	
	ReservaController(ReservaRepository repository) {
		this.reservas = repository;
	}
	
	@GetMapping("/reservas")
	public List<Reserva> listar() {
		return reservas.findAll();
	}
	
	@GetMapping("/reservas/{id}")
	Optional<Reserva> one(@PathVariable Long id) {

		return reservas.findById(id);
	}

	@PostMapping("/reservas")
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva adicionarReserva(@Valid @RequestBody Reserva reserva) {
		Optional<Reserva> reservaExistente  =  reservas.findBySalaAndLocalFilialAndDataHoraInicialAndDataHoraFinal(reserva.getSala(), reserva.getLocalFilial(), reserva.getDataHoraInicial(), reserva.getDataHoraFinal());
		
		if(reservaExistente.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma reserva com esse horário, sala e local");
			
		}
		return reservas.save(reserva);
	}
	
	@PutMapping("/reservas/{id}")
	Reserva replaceEmployee(@RequestBody Reserva newEmployee, @PathVariable Long id) {

		return reservas.findById(id)
			.map(employee -> {
				employee.setLocalFilial(newEmployee.getLocalFilial());
				employee.setSala(newEmployee.getSala());
				employee.setDataHoraInicial(newEmployee.getDataHoraInicial());
				employee.setDataHoraFinal(newEmployee.getDataHoraFinal());
				employee.setCafe(newEmployee.isCafe());
				employee.setQuantidade(newEmployee.getQuantidade());
				employee.setDescricao(newEmployee.getDescricao());
				
				return reservas.save(employee);
			})
			.orElseGet(() -> {
				newEmployee.setId(id);
				return reservas.save(newEmployee);
			});
	} 
	
	@DeleteMapping("/reservas/{id}")
	void deleteEmployee(@PathVariable Long id) {
		reservas.deleteById(id);
	}
}