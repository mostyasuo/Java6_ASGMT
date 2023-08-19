package model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



public interface RoleDetailsDao extends JpaRepository<RoleDetails, Integer> {

	@Query("SELECT DISTINCT a FROM RoleDetails a WHERE a.account IN ?1")
	List<RoleDetails> authoritiesOf(List<Account> accounts);
}