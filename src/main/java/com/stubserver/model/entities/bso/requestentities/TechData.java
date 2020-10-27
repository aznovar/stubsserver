package com.stubserver.model.entities.bso.requestentities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechData {
    @SerializedName("disableCacheWrites")
    @Expose
    private Boolean disableCacheWrites;
    @SerializedName("actionId")
    @Expose
    private String actionId;
    @SerializedName("correlationId")
    @Expose
    private String correlationId;
    @SerializedName("disableCacheReads")
    @Expose
    private Boolean disableCacheReads;
}
