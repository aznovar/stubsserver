package com.stubserver.model.entities.bso.requestentities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BusinessData {
    @SerializedName("bso")
    @Expose
    private Bso bso;
    @SerializedName("agent")
    @Expose
    private Agent agent;
    @SerializedName("issueDate")
    @Expose
    private String issueDate;
}
