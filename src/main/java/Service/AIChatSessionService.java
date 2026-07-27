package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.AIChatSessionRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AIChatSessionService {
	
	@Autowired
	private AIChatSessionRepo aIChatSessionRepo;
	
	public List<AIChatSession> getAllAiChatSessions(){
		 return aIChatSessionRepo.findAll();
	}
	
	public Optional<AIChatSession> getAIChatSession(Long id) {
		return aIChatSessionRepo.findById(id);
	}

	public AIChatSession newAIChatSession(AIChatSession aIChatSession) {
		return  aIChatSessionRepo.save(aIChatSession);
	}
	
	public void deleteAIChatSession(Long id) {
		aIChatSessionRepo.deleteById(id);
	}
}
