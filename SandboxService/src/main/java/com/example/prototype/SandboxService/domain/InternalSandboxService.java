package com.example.prototype.SandboxService.domain;

import com.example.prototype.SandboxService.resource.api.AgreementResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InternalSandboxService {

    @Autowired
    RestTemplate restTemplate;

    String typeEndpoint = "http://localhost:8082/prototype/service/type?typeId=%s";

    public String localHello(){
        var response = restTemplate.getForEntity("http://localhost:8082/prototype/service/hello", String.class);
        return response.getBody();
    }

    public AgreementResponse localGetType(int typeId){
        var response = restTemplate.getForEntity(String.format(typeEndpoint, typeId), AgreementResponse.class);
        return response.getBody();
    }
}
