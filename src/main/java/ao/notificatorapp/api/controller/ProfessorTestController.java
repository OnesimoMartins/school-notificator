package ao.notificatorapp.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.notificatorapp.api.dto.input.TestResultInput;
import ao.notificatorapp.api.dto.response.TestResultRresponse;
import ao.notificatorapp.domain.service.ProfessorService;

@RestController
@RequestMapping("professors/{idProfessor}/tests/")

public class ProfessorTestController {

	@Autowired
	private ProfessorService profService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)

	public TestResultRresponse postTest(@RequestBody @Valid TestResultInput result,
			@PathVariable Long idProfessor) {
		
	return	profService.setStudentTestResult(idProfessor, result.toTestResult());
		
	
	}

}
