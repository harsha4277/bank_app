package com.harsha.banking.service;

import com.harsha.banking.dto.AccountDto;
import com.harsha.banking.entity.Account;

public interface AccountServices {
    AccountDto createAccount(AccountDto accountDto);
}
