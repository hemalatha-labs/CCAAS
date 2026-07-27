package Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import model.*;
import Repo.AuditLogRepo;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditLogService {
	
	@Autowired
	private AuditLogRepo auditLogRepo;
	
	public List<AuditLog> getAllAuditLogs(){
		 return auditLogRepo.findAll();
	}
	
	public Optional<AuditLog> getAuditLog(Long id) {
		return auditLogRepo.findById(id);
	}

	public AuditLog newAuditLog(AuditLog auditLog) {
		return  auditLogRepo.save(auditLog);
	}
	
	public void deleteAuditLog(Long id) {
		auditLogRepo.deleteById(id);
	}
}
