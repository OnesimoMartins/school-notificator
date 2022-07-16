package ao.notificatorapp.domain.exception;

public class ProfessorNotFound extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ProfessorNotFound(Long id) {
	super("there is not professor using id "+id);
	}
}
