package br.com.serratec.gestaoserratec.exception;

public class ResourceBadRequestException extends RuntimeException {

	public ResourceBadRequestException(String mensagem) {
		super(mensagem);
	}
}
