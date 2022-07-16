package ao.notificatorapp.domain.exception;

public class NotLessonSelectedForThisStudentException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotLessonSelectedForThisStudentException(String msg) {
	
		super(msg);
	}
}
