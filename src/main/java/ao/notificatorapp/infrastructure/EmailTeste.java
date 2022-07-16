package ao.notificatorapp.infrastructure;

import org.springframework.stereotype.Service;

import ao.notificatorapp.domain.service.EmailService;

@Service
public class EmailTeste implements EmailService{

	
	@Override
	public void sendEmail(String nome) {
		for (int i = 0; i < 7; i++) {
			System.out.println("ENVIANDO EMAIL PARA "+nome);
		
		}
	}

}
