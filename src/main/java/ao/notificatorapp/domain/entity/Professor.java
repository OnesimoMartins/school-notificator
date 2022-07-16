package ao.notificatorapp.domain.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import ao.notificatorapp.domain.exception.NotLessonSelectedForThisStudentException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter
@Entity
@ToString
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@OneToOne
	private Lesson lesson;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( name="student_professor",joinColumns = @JoinColumn(name="professor_id")
	,inverseJoinColumns = @JoinColumn(name="student_id"))
	private List<Student> students;
	
	
	public void insertStudentMark(Student st,Byte mark) {
		
		var student =this.students.stream().filter(x->x.getId().equals(st.getId()))
		.findFirst().orElseThrow(
				()->new NotLessonSelectedForThisStudentException("this student does not have this Lesson"));
	
		student.getSelectedLessons().parallelStream().filter(x->x.getLesson().equals(this.lesson))
		.findFirst().get().setResult(mark);;
		
	}

}
