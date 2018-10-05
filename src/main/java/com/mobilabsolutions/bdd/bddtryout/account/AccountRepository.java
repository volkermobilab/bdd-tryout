package com.mobilabsolutions.bdd.bddtryout.account;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepository {

	private Map<String, Account> accountTable;

	public AccountRepository() {
		this.accountTable = new HashMap<>();
	}

	public void createAccount(Account account) {
		if (accountTable.get(account.getUsername()) != null) {
			throw new HttpStatusException(HttpStatus.CONFLICT);
		}
		this.accountTable.put(account.getUsername(), account);
	}

	public Account getAccount(String username) {
		if (accountTable.get(username) == null) {
			throw new HttpStatusException(HttpStatus.NOT_FOUND);
		}
		return this.accountTable.get(username);
	}

	public void deleteAccount(String username) {
		this.accountTable.remove(username);
	}

	public List<Account> getAccounts() {
		return new ArrayList<>(this.accountTable.values());
	}

}
