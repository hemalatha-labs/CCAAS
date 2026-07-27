package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.ComplianceFrameworkRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplianceFrameworkService {

	
	@Autowired
	private ComplianceFrameworkRepo complianceFrameworkRepo;
	
	public List<ComplianceFramework> getAllComplianceFrameworks(){
		 return complianceFrameworkRepo.findAll();
	}
	
	public Optional<ComplianceFramework> getComplianceFramework(Long id) {
		return complianceFrameworkRepo.findById(id);
	}

	public ComplianceFramework newComplianceFramework(ComplianceFramework complianceFramework) {
		return  complianceFrameworkRepo.save(complianceFramework);
	}
	
	public void deleteComplianceFramework(Long id) {
		complianceFrameworkRepo.deleteById(id);
	}
}
