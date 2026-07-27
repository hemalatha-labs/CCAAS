package Repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.ResourceTag;
@Repository
public interface ResourceTagRepo extends JpaRepository<ResourceTag,Long> {

}
