package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.RemediationSuggestionRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RemediationSuggestionService {
	
	@Autowired
	private RemediationSuggestionRepo remediationSuggestionRepo;
	
	public List<RemediationSuggestion> getAllRemediationSuggestions(){
		 return remediationSuggestionRepo.findAll();
	}
	
	public Optional<RemediationSuggestion> getRemediationSuggestion(Long id) {
		return remediationSuggestionRepo.findById(id);
	}

	public RemediationSuggestion newRemediationSuggestion(RemediationSuggestion remediationSuggestion) {
		return  remediationSuggestionRepo.save(remediationSuggestion);
	}
	
	public void deleteRemediationSuggestion(Long id) {
		remediationSuggestionRepo.deleteById(id);
	}
}
