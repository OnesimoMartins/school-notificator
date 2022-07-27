package ao.notificatorapp.domain.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import ao.notificatorapp.api.dto.response.TestResultRresponse;
import ao.notificatorapp.domain.entity.Professor;
import ao.notificatorapp.domain.entity.TestResult;
import ao.notificatorapp.domain.event.TestResultPublishedEvent;
import ao.notificatorapp.domain.exception.ProfessorNotFound;
import ao.notificatorapp.domain.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired private ProfessorRepository profs;
	
	@Autowired private StudentService students;
	
	@Autowired
	private  ApplicationEventPublisher publisher;
	
	
	public Professor getProfessorByIdOrFail(Long id) {
		return profs.findById(id).orElseThrow(
				()-> new ProfessorNotFound(id));
	}
	
	@Transactional
	public TestResultRresponse setStudentTestResult(Long profId, TestResult result ) {
		
		var prof=this.getProfessorByIdOrFail(profId);
		
		var student= students.findStudentByIdOrFail(result.getStudentId());
		
		prof.insertStudentMark(student, result.getResult());
		
		publisher.publishEvent(new TestResultPublishedEvent(result,student));
		
		return new  TestResultRresponse(result.getResult(), student.getName());
		
	}
	
	
}
