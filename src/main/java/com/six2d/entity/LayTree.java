package com.six2d.entity;

import java.util.ArrayList;
import java.util.List;

public class LayTree {
    private String title;
    private Integer id;
    private Integer field;
    private List<LayTree> children;

    public LayTree() {
        children = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getField() {
        return field;
    }

    public void setField(Integer field) {
        this.field = field;
    }

    public List<LayTree> getChildren() {
        return children;
    }

    public void setChildren(List<LayTree> children) {
        this.children = children;
    }
}
