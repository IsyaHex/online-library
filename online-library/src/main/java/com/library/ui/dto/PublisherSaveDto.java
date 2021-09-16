package com.library.ui.dto;

import java.time.ZonedDateTime;

public class PublisherSaveDto {
    private Long id;
    private String publisherName;
    private String location;
    private String translatedLanguages;
    private Integer publishedQuantity;
    private Double avgPrice;
    private String about;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTranslatedLanguages() {
        return translatedLanguages;
    }

    public void setTranslatedLanguages(String translatedLanguages) {
        this.translatedLanguages = translatedLanguages;
    }

    public Integer getPublishedQuantity() {
        return publishedQuantity;
    }

    public void setPublishedQuantity(Integer publishedQuantity) {
        this.publishedQuantity = publishedQuantity;
    }

    public Double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(Double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(ZonedDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
