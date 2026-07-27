package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.NotificationRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationService {
	
	@Autowired
	private NotificationRepo notificationRepo;
	
	public List<Notification> getAllUsers(){
		 return notificationRepo.findAll();
	}
	
	public Optional<Notification> getNotification(Long id) {
		return notificationRepo.findById(id);
	}

	public Notification newNotification(Notification notification) {
		return  notificationRepo.save(notification);
	}
	
	public void deleteNotification(Long id) {
		notificationRepo.deleteById(id);
	}
}
