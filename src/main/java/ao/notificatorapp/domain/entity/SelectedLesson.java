package ao.notificatorapp.domain.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.ToString;

@Getter
@Entity
@ToString
public class SelectedLesson {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	@JoinColumn(name="lesson_id")
	private Lesson lesson;
//	
//	@OneToOne
//	@JoinColumn(name = "id")
//	private Student student;
	

	private Byte firstTest;
	
	private Byte secondTest;
	
	@Enumerated(EnumType.STRING)
	private LessonStatus status=LessonStatus.WITHOUT_RESULT_YET;
	
	public  void setResult(Byte mark) {
		
		if(this.getFirstTest()==null) {
			this.firstTest=mark;
		 	}
		
		else 
			if(secondTest==null) {
			  this.secondTest=mark;
			  var finalReslut=(firstTest+secondTest)/2;
		    
			  if(finalReslut>=10)
		    	this.status=LessonStatus.APPROVED;
			  
			  else if(finalReslut==9) this.status=LessonStatus.REPEAT_TEST;
			  
			  else  this.status=LessonStatus.REPROBATED;
			}
		
	}


}
