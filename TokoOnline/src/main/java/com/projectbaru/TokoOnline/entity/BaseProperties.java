package com.projectbaru.TokoOnline.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseProperties {
    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean is_delete = false;


    public Boolean isIs_delete() {
        return this.is_delete;
    }

    public Boolean getIs_delete() {
        return this.is_delete;
    }

    public void setIs_delete(Boolean is_delete) {
        this.is_delete = is_delete;
    }
}
