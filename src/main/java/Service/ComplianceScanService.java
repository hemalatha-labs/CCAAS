package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.ComplianceScanRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComplianceScanService {
	
	@Autowired
	private ComplianceScanRepo complianceScanRepo;
	
	public List<ComplianceScan> getAllComplianceScans(){
		 return complianceScanRepo.findAll();
	}
	
	public Optional<ComplianceScan> getComplianceScan(Long id) {
		return complianceScanRepo.findById(id);
	}

	public ComplianceScan newComplianceScan(ComplianceScan complianceScan) {
		return  complianceScanRepo.save(complianceScan);
	}
	
	public void deleteComplianceScan(Long id) {
		complianceScanRepo.deleteById(id);
	}
}
