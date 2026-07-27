package Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import model.RemediationSuggestion;
public interface RemediationSuggestionRepo extends JpaRepository<RemediationSuggestion,Long> {

}
