package br.com.serratec.gestaoserratec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.gestaoserratec.model.Casa;

@Repository // Pedreiro, Pintor, Servente ...
public interface CasaRepository extends JpaRepository<Casa, Long> {

}
