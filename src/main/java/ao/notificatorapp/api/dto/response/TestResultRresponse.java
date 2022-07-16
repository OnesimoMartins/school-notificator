package ao.notificatorapp.api.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class TestResultRresponse {

	
	private final Byte mark;
	
	@JsonProperty("student_name")
	private final String StudentName;
	
	@JsonProperty("published_on")
	private final LocalDate publishedOn;
	
	
	public TestResultRresponse(byte mark, String name) {
	this.mark=mark;
	this.StudentName=name;
	}
	
}
