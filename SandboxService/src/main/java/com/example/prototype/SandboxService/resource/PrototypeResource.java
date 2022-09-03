package com.example.prototype.SandboxService.resource;

import com.example.prototype.SandboxService.domain.InternalSandboxService;
import com.example.prototype.SandboxService.resource.api.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrototypeResource {
    @Autowired
    InternalSandboxService internalSandboxService;

    @GetMapping("hello")
    public String getHello(){
        return "hello";
    }

    @GetMapping("local/hello")
    public String getLocalHello(){
        return internalSandboxService.localHello();
    }

    @GetMapping("type")
    public AgreementResponse getType(@RequestParam(required = false) int typeId){
        ObjectMapper objectMapper = new ObjectMapper();

        switch (typeId) {
            case 1:
                return AgreementResponse.builder()
                        .agreementType(AgreementType.SAVINGS)
                        .agreement(objectMapper.convertValue(new SavingsAgreement("agr", 2d, 0), JsonNode.class)).build();
            case 2:
                return AgreementResponse.builder()
                        .agreementType(AgreementType.SAVINGS)
                        .agreement(objectMapper.convertValue(new CreditAgreement("agr", 2d, 3d), JsonNode.class)).build();
            default:
                return null;
        }
    }

    @GetMapping("local/type")
    public AgreementResponse getLocalType(@RequestParam(required = false) int typeId) {
        return internalSandboxService.localGetType(typeId);
    }
}
