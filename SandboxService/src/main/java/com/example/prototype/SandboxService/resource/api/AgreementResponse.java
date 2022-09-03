package com.example.prototype.SandboxService.resource.api;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgreementResponse<T extends Agreement> {
    private AgreementType agreementType;
    private JsonNode agreement;
}
