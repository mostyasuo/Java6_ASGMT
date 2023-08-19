package Controller;

import java.util.List;

import model.Account;



public interface AccountService {
	public List<Account> findAll() ;
	public Account findById(String username) ;
	public List<Account> getAdministrators() ;
}
