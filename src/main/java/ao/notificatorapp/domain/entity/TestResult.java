package ao.notificatorapp.domain.entity;

import ao.notificatorapp.api.dto.input.TestResultInput;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TestResult {
	private final Byte result;
	private final Long studentId;
	
	
	public TestResult(TestResultInput input) {
		this.result=input.getResult();
		this.studentId=input.getStudentId();
	}
}