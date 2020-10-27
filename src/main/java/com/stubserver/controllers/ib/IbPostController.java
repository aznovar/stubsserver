package com.stubserver.controllers.ib;

import com.stubserver.model.service.ib.IbRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ib/v1/")
public class IbPostController {

    private final IbRemote<String> ibRemote;

    @Autowired
    public IbPostController(IbRemote ibRemote) {
        this.ibRemote = ibRemote;
    }

    @PostMapping("calculateResponse")
    public ResponseEntity calculateResponseXml(@RequestBody String incomingXml) throws Exception {
        return ResponseEntity.ok(ibRemote.formingResponse(incomingXml));
    }

}
