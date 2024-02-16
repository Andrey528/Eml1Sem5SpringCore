package com.example.Eml1Sem5SpringCore.controllers;

import com.example.Eml1Sem5SpringCore.dpo.TransferRequest;
import com.example.Eml1Sem5SpringCore.models.Account;
import com.example.Eml1Sem5SpringCore.services.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AccountController {
    private final TransferService transferService;


    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest request
    ) {
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount());
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name
    ) {
        if (name == null) {
            return transferService.getAllAccounts();
        } else {
            return transferService.findAccountsByName(name);
        }
    }
}
