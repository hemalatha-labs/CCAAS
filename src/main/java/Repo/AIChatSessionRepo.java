package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.AIChatSession;
@Repository

public interface AIChatSessionRepo  extends JpaRepository<AIChatSession,Long>{

}
