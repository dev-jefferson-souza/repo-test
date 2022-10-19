package br.com.serratec.gestaoserratec.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.serratec.gestaoserratec.exception.ResourceBadRequestException;
import br.com.serratec.gestaoserratec.exception.ResourceNotFoundException;
import br.com.serratec.gestaoserratec.model.error.MensagemError;
import br.com.serratec.gestaoserratec.utils.ConversorDeData;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MensagemError> handlerResourceNotFoundException(ResourceNotFoundException ex){
		
		//Pego a data e hora atual no formato "18/10/2022 as 19:54hs";
		String dataHora = ConversorDeData.converterDateParaDataEHora(new Date());
		
		// Constroi o objeto de erro com base na exception.
		MensagemError erro =  new MensagemError(dataHora, 404, "Not Found", ex.getMessage());
		
		// Aqui eu estou devolvendo o objeto de erro montado com o status especifico que desejo, neste caso é o not found 404
		return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceBadRequestException.class)
	public ResponseEntity<MensagemError> handlerBadRequestException(ResourceBadRequestException ex){
		
		String dataHora  = ConversorDeData.converterDateParaDataEHora(new Date());
		MensagemError erro =  new MensagemError(dataHora, 400, "Bad Request", ex.getMessage());
				
		return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
	}
	
	// Tratamento geral maroto que estamos fazendo para qualquer excption não tratada.
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MensagemError> handlerBadRequestException(Exception ex){
		String dataHora  = ConversorDeData.converterDateParaDataEHora(new Date());
		MensagemError erro =  new MensagemError(dataHora, 500, "Internal Server Error", ex.getMessage());
				
		return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
