package Controller;

import java.util.List;

import model.RoleDetails;


public interface RoleDetailsService {
	public List<RoleDetails> findAll() ;

	public RoleDetails create(RoleDetails roledtails) ;

	public void delete(Integer id) ;

	public List<RoleDetails> findAuthoritiesOfAdministrators() ;
}
