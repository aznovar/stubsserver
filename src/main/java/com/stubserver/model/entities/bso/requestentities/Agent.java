package com.stubserver.model.entities.bso.requestentities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Agent {

    @SerializedName("lnr")
    @Expose
    private Integer lnr;
    @SerializedName("skk")
    @Expose
    private Integer skk;

}
