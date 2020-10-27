package com.stubserver.model.service.bso;

import com.stubserver.model.entities.bso.requestentities.FullBSOEntity;
import com.stubserver.model.entities.bso.responseentities.BusinessDataResp;
import com.stubserver.model.entities.bso.responseentities.FullBSOEntityResp;
import com.stubserver.model.entities.bso.responseentities.TechDataResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FormingResponseBso implements BsoRemote<FullBSOEntityResp> {

    @Override
    public FullBSOEntityResp formingResponse(FullBSOEntity fullBSOEntityRequest) {
        FullBSOEntityResp fullBSOEntityResp = new FullBSOEntityResp();
        BusinessDataResp businessDataResp = new BusinessDataResp();
        TechDataResp techDataResp = new TechDataResp();

        String correlationId = fullBSOEntityRequest.getTechData().getCorrelationId();
        String actionId = fullBSOEntityRequest.getTechData().getActionId();
        String type = fullBSOEntityRequest.getBusinessData().getBso().getType();
        if (type.equals("1001")) {
            businessDataResp.setSystem("10");
        }
        if (type.equals("101") || type.equals("40") || type.equals("9024")) {
            businessDataResp.setSystem("1");
        }
        techDataResp.setActionId(actionId);
        techDataResp.setCorrelationId(correlationId);
        techDataResp.setErrorDescription(null);
        techDataResp.setResponseCode("0");
        techDataResp.setIsDataFromCache(false);
        businessDataResp.setSystem("1");
        businessDataResp.setResult("Ok");
        fullBSOEntityResp.setBusinessDataResp(businessDataResp);
        fullBSOEntityResp.setTechDataResp(techDataResp);
        return fullBSOEntityResp;
    }
}
