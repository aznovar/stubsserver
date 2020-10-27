package com.stubserver.model.entities.bso.requestentities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FullBSOEntity {
    @SerializedName("techData")
    @Expose
    private TechData techData;
    @SerializedName("businessData")
    @Expose
    private BusinessData businessData;
}
