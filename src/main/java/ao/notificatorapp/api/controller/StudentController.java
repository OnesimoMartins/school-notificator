package ao.notificatorapp.api.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ao.notificatorapp.api.dto.response.ResponseUtils;
import ao.notificatorapp.api.dto.response.SelectedLessonResponse;
import ao.notificatorapp.domain.service.StudentService;

@RequestMapping("students/{studentId}")
@RestController
public class StudentController {

	@Autowired private StudentService students;
	
	@GetMapping("/lessons")
	public  Set<SelectedLessonResponse> getAllLessonResult(@PathVariable Long studentId) {		
		return ResponseUtils.getSelectedLessonResponse(
		students.findStudentByIdOrFail(studentId).getSelectedLessons()
		);
	}
//	@GetMapping()
	
}
