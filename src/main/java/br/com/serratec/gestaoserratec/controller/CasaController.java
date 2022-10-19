package br.com.serratec.gestaoserratec.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.gestaoserratec.model.Casa;
import br.com.serratec.gestaoserratec.service.CasaService;

@RestController // Corretor
@RequestMapping("/api/casas") // Só entra aqui se na url tiver essa URI.
public class CasaController {

	@Autowired
	private CasaService servico;
	
	@GetMapping
	public ResponseEntity<List<Casa>> obterTodos(){
		
		List<Casa> lista = servico.obterTodos();
		return ResponseEntity.ok(lista); // 200
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Casa> obterPorId(@PathVariable Long id){
		
		Optional<Casa> optCasa = servico.obterPorId(id);
		return ResponseEntity.ok(optCasa.get()); // 200
	}
	
	@PostMapping 
	public ResponseEntity<Casa> cadastrar(@RequestBody Casa casa) {
		casa = servico.cadastrar(casa);
		return new ResponseEntity<>(casa, HttpStatus.CREATED); // 201
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Casa> atualizar(@PathVariable Long id, @RequestBody Casa casa) {
		return ResponseEntity.ok(servico.atualizar(id, casa)); // 200
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		servico.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}
}
