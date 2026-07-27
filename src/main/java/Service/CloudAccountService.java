package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.CloudAccountRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CloudAccountService {

	
	@Autowired
	private CloudAccountRepo cloudAccountRepo;
	
	public List<CloudAccount> getAllUsers(){
		 return cloudAccountRepo.findAll();
	}
	
	public Optional<CloudAccount> getUser(Long id) {
		return cloudAccountRepo.findById(id);
	}

	public CloudAccount newCloudAccount(CloudAccount cloudAccount) {
		return  cloudAccountRepo.save(cloudAccount);
	}
	
	public void deleteUSer(Long id) {
		cloudAccountRepo.deleteById(id);
	}
}
