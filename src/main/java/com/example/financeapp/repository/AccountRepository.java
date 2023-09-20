package com.example.financeapp.repository;

import com.example.financeapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

Account getAccountByAccountId(Long accountId);

}
