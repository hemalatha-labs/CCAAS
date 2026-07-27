package Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.CloudAccount;
@Repository
public interface CloudAccountRepo extends JpaRepository<CloudAccount,Long> {

}
