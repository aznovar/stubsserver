package com.stubserver.controllers.bso;

import com.stubserver.model.entities.bso.requestentities.FullBSOEntity;

import com.stubserver.model.entities.bso.responseentities.FullBSOEntityResp;
import com.stubserver.model.service.bso.BsoRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bso/v1/")
public class RegisterBSOController {

    private final BsoRemote<FullBSOEntityResp> bsoRemote;

    @Autowired
    public RegisterBSOController(BsoRemote bsoRemote) {
        this.bsoRemote = bsoRemote;
    }

    @PostMapping("registerBso")
    public ResponseEntity registerBso(@RequestBody FullBSOEntity fullBSOEntity) {
        return ResponseEntity.ok(bsoRemote.formingResponse(fullBSOEntity));
    }
}
