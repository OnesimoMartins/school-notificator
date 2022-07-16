package ao.notificatorapp.domain.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import ao.notificatorapp.domain.event.TestResultPublishedEvent;
import ao.notificatorapp.domain.service.EmailService;


@Component
public class TestResultPublishedListener {

	@Autowired
	private EmailService emailService;
	
	
	@EventListener
	private void onTestResultPublished (TestResultPublishedEvent e) {
		
		for(byte i=0;i!=7;i++)
			emailService.sendEmail(e.getTestResult().getStudentId().toString());
		//Mensagem
	}
}
