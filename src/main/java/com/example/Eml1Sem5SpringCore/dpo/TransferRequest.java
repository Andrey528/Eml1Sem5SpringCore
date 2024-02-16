package com.example.Eml1Sem5SpringCore.dpo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    private Long senderAccountId;
    private Long receiverAccountId;
    private BigDecimal amount;
}
