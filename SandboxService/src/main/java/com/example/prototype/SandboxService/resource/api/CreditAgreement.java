package com.example.prototype.SandboxService.resource.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreditAgreement extends Agreement{
    public Double owedAmount;

    public CreditAgreement(String name, Double balance, Double owedAmount){
        super(name, balance);
        this.owedAmount = owedAmount;
    }
}
