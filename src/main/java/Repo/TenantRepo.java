package Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Tenant;
@Repository
public interface TenantRepo extends JpaRepository<Tenant, Long>  {


}
