package Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.CloudResource;
@Repository

public interface CloudResourceRepo extends JpaRepository<CloudResource,Long>{

}
