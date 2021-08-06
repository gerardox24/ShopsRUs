package com.baufest.shopsrus.domain;

import com.baufest.shopsrus.persistence.entity.Invoice;
import com.baufest.shopsrus.persistence.entity.UserType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

public class UserDomain {
    private int id;
    private int userTypeId;
    private String lastname;
    private String name;
    private String documentType;
    private String document;
    private Boolean isAffiliated;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(Integer userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Boolean getAffiliated() {
        return isAffiliated;
    }

    public void setAffiliated(Boolean affiliated) {
        isAffiliated = affiliated;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
