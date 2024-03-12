package com.harsha.banking.service.impl;

import com.harsha.banking.dto.AccountDto;
import com.harsha.banking.entity.Account;
import com.harsha.banking.mapper.AccountMapper;
import com.harsha.banking.repository.AccountRepository;
import com.harsha.banking.service.AccountServices;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountServices {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
