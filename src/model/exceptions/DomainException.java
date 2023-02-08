package model.exceptions;

public class DomainException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	//Instanciar Exceção personalizada passando uma mensagem pra ela
	public DomainException(String msg) {
		super(msg);
	}
}
