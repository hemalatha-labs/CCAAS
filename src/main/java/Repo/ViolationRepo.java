package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Violation;
@Repository

public interface ViolationRepo extends JpaRepository<Violation,Long>{

}
