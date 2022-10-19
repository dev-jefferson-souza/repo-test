package br.com.serratec.gestaoserratec.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.gestaoserratec.exception.ResourceBadRequestException;
import br.com.serratec.gestaoserratec.exception.ResourceNotFoundException;
import br.com.serratec.gestaoserratec.model.Casa;
import br.com.serratec.gestaoserratec.repository.CasaRepository;

@Service // Arquiteto
public class CasaService {

	@Autowired
	private CasaRepository repositorio;
	
	public List<Casa> obterTodos() {
		return repositorio.findAll();
	}
	
	public Optional<Casa> obterPorId(Long id){
		
		Optional<Casa> optCasa = repositorio.findById(id);
		
		if(optCasa.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possivel encontrar a casa com id " + id);
		}
		
		return optCasa;
	}
	
	public Casa cadastrar(Casa casa) {
		
		validarModelo(casa);
		
		casa.setId(null);
		return repositorio.save(casa);
	}
	
	public Casa atualizar(Long id, Casa casa) {
		
		//Usando o metodo somente para validar se existe algo com o id informado.
		obterPorId(id);
		
		validarModelo(casa);
		
		casa.setId(id);
		return repositorio.save(casa);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	private void validarModelo(Casa casa) {
		
		if(casa.getMetragem() == null) {
			throw new ResourceBadRequestException("A metragem deve ser informada.");
		}else if (casa.getMetragem() < 1) {
			throw new ResourceBadRequestException("A metragem deve ser maior que 0.");
		}	
	
	}
	
}
