package com.example.prototype.SandboxService.resource.api;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SavingsAgreement extends Agreement{
    public int noOfStops;

    public SavingsAgreement(String name, Double balance, int noOfStops){
        super(name, balance);
        this.noOfStops = noOfStops;
    }
}
