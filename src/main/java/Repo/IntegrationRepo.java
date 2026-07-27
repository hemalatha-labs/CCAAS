package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Integration;
@Repository

public interface IntegrationRepo extends JpaRepository<Integration,Long> {

}
