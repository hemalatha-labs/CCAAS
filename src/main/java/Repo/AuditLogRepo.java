package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.AuditLog;
@Repository
public interface AuditLogRepo extends JpaRepository<AuditLog,Long>{

}
