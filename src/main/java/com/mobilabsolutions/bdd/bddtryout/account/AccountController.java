package com.mobilabsolutions.bdd.bddtryout.account;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

	private AccountRepository accountRepository;

	public AccountController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@PostMapping("/accounts")
	public void registerAccount(@RequestBody Account account) {
		this.accountRepository.createAccount(account);
	}

	@GetMapping("/accounts")
	public List<Account> getAccounts() {
		return this.accountRepository.getAccounts();
	}

	@GetMapping("/accounts/{username}")
	public Account getAccount(@PathVariable String username) {
		return this.accountRepository.getAccount(username);
	}

	@DeleteMapping("/accounts/{username}")
	public void deleteAccount(@PathVariable String username) {
		this.accountRepository.deleteAccount(username);
	}

}
