package ao.notificatorapp.api.dto.input;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import ao.notificatorapp.domain.entity.TestResult;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestResultInput {

	@Min(value = 0)
	@Max(20)
	@NotNull
	private  Byte result;
	
	@NotNull
	private Long studentId;
	
	public TestResult toTestResult() {
		return new TestResult(this);
	}
	
}
