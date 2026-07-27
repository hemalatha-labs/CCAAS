package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.RemediationScript;
@Repository

public interface RemediationScriptRepo extends JpaRepository<RemediationScript,Long> {

}
