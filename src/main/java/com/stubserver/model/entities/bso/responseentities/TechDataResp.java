package com.stubserver.model.entities.bso.responseentities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechDataResp {

    @SerializedName("correlationId")
    @Expose
    private String correlationId;
    @SerializedName("actionId")
    @Expose
    private String actionId;
    @SerializedName("responseCode")
    @Expose
    private String responseCode;
    @SerializedName("errorDescription")
    @Expose
    private Object errorDescription;
    @SerializedName("isDataFromCache")
    @Expose
    private Boolean isDataFromCache;
}
