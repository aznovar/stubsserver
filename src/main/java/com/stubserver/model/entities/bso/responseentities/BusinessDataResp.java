package com.stubserver.model.entities.bso.responseentities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessDataResp {
    @SerializedName("result")
    @Expose
    private String result;
    @SerializedName("system")
    @Expose
    private String system;
}
