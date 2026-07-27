package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.IntegrationRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IntegrationService {

	
	@Autowired
	private IntegrationRepo integrationRepo;
	
	public List<Integration> getAllIntegrations(){
		 return integrationRepo.findAll();
	}
	
	public Optional<Integration> getIntegration(Long id) {
		return integrationRepo.findById(id);
	}

	public Integration newIntegration(Integration integration) {
		return  integrationRepo.save(integration);
	}
	
	public void deleteIntegration(Long id) {
		integrationRepo.deleteById(id);
	}
}