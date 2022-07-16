package ao.notificatorapp.domain.entity;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Responsible {

	private Long id;
	private String name;
	private String email;
	private List<Student> sons;//filhos encarregado
}
