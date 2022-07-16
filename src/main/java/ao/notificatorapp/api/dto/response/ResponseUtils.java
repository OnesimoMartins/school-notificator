package ao.notificatorapp.api.dto.response;

import java.util.HashSet;
import java.util.Set;

import ao.notificatorapp.domain.entity.SelectedLesson;

public abstract class ResponseUtils {

	public static SelectedLessonResponse getSelectedLessonResponse(SelectedLesson lesson) {
		var lessonResponse=new SelectedLessonResponse(); 
		lessonResponse.setFirstTest(lesson.getFirstTest());
		lessonResponse.setSecondTest(lesson.getSecondTest());
		lessonResponse.setId(lesson.getId());
		lessonResponse.setLessonStatus(lesson.getStatus());
		lessonResponse.setName(lesson.getLesson().getName());
		return lessonResponse;
	}
	
	public static Set<SelectedLessonResponse> getSelectedLessonResponse(Set<SelectedLesson> lessons) {
		var lessonsResponse=new HashSet<SelectedLessonResponse>();
		lessons.forEach(x-> lessonsResponse.add( getSelectedLessonResponse( x )));
				return lessonsResponse;
	}
}
