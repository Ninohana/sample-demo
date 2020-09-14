package com.six2d.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DsSection {
    @JsonProperty(value = "id")
    private Integer section_id;

    @JsonProperty(value = "name")
    private String section_name;

    @JsonProperty(value = "pId")
    private Integer section_pId;

    @JsonIgnore
    private Integer section_status;

    public DsSection() {
    }

    public Integer getSection_id() {
        return section_id;
    }

    public void setSection_id(Integer section_id) {
        this.section_id = section_id;
    }

    public String getSection_name() {
        return section_name;
    }

    public void setSection_name(String section_name) {
        this.section_name = section_name;
    }

    public Integer getSection_pId() {
        return section_pId;
    }

    public void setSection_pId(Integer section_pId) {
        this.section_pId = section_pId;
    }

    public Integer getSection_status() {
        return section_status;
    }

    public void setSection_status(Integer section_status) {
        this.section_status = section_status;
    }
}
