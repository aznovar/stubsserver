package com.stubserver.model.entities.bso.responseentities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullBSOEntityResp {

    @SerializedName("techData")
    @Expose
    private TechDataResp techDataResp;
    @SerializedName("businessData")
    @Expose
    private BusinessDataResp businessDataResp;

}
