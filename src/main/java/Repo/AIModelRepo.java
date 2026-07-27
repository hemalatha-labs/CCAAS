package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.AIModel;
@Repository

public interface AIModelRepo extends JpaRepository<AIModel,Long> {

}
