package ao.notificatorapp.domain.service;

import org.springframework.stereotype.Service;

import ao.notificatorapp.domain.entity.Student;
import ao.notificatorapp.domain.exception.StudentNotFoundException;
import ao.notificatorapp.domain.repository.StudentRepository;

@Service
public class StudentService {
	private StudentRepository studentRepository;
	
	public StudentService(StudentRepository repository) {
	this.studentRepository=repository;
	}
	
	public Student findStudentByIdOrFail (Long id) {
		return this.studentRepository.findById(id).orElseThrow(
				()->new StudentNotFoundException("there is no student with id "+id)
				);
	}
}
