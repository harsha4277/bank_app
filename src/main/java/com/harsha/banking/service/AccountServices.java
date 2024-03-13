package com.harsha.banking.service;

import com.harsha.banking.dto.AccountDto;
import com.harsha.banking.entity.Account;

import java.util.List;

public interface AccountServices {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);
}
