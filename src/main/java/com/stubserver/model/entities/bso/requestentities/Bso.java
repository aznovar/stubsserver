package com.stubserver.model.entities.bso.requestentities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Bso {

    @SerializedName("series")
    @Expose
    private String series;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("statuses")
    @Expose
    private List<String> statuses = null;
}
