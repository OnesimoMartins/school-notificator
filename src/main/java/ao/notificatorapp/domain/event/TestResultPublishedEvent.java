package ao.notificatorapp.domain.event;

import ao.notificatorapp.domain.entity.Student;
import ao.notificatorapp.domain.entity.TestResult;
import lombok.Getter;

@Getter
public class TestResultPublishedEvent implements Event {
	private final TestResult testResult;
	private final Student student;
	
	public TestResultPublishedEvent(TestResult result,Student student){
		this.testResult=result;
		this.student=student;
	}
}
