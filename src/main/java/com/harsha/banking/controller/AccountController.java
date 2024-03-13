package com.harsha.banking.controller;


import com.harsha.banking.dto.AccountDto;
import com.harsha.banking.entity.Account;
import com.harsha.banking.service.AccountServices;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountServices accountServices;

    public AccountController(AccountServices accountServices) {
        this.accountServices = accountServices;
    }

    // Add Account Rest APi
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountServices.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Get Account REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto= accountServices.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    // Deposit Rest API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto>deposit(@PathVariable Long id,
                                             @RequestBody Map<String,Double> request){
       AccountDto accountDto = accountServices.deposit(id, request.get("amount"));
       return ResponseEntity.ok(accountDto);
    }

    //Withdraw Rest API

    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto>withdraw(@PathVariable Long id,
                                             @RequestBody Map<String,Double> request){
        AccountDto accountDto = accountServices.withdraw(id, request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    // Get all accounts Rest API

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accounts= accountServices.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    // Delete Account Rest API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountServices.deleteAccount(id);
        return ResponseEntity.ok("Account deleted successfully");
    }
}
