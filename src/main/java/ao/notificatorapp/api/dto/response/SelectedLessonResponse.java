package ao.notificatorapp.api.dto.response;

import ao.notificatorapp.domain.entity.LessonStatus;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SelectedLessonResponse {
	private Long id;
	private String name;
	private Byte firstTest;
	private Byte secondTest;
	private LessonStatus lessonStatus;
	
}
