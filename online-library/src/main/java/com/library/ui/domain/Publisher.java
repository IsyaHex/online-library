package com.library.ui.domain;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;


@Entity
@Table(name = "publisher")
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "publisher_seq")
    @SequenceGenerator(name = "publisher_seq", sequenceName = "seq_publisher", allocationSize = 1)
    private Long id;

    @Column(name = "publisher_name")
    private String publisherName;

    @Column(name = "location")
    private String location;

    @Column(name = "translated_languages")
    private String translatedLanguages;

    @Column(name = "published_quantity")
    private Integer publishedQuantity;

    @Column(name = "average_book_price")
    private Double avgPrice;

    @Column(name = "about_publisher")
    private String about;

    @Column(name  = "created_at")
    private ZonedDateTime createdAt;

    @Column(name = "updated_at")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;
        Publisher publisher = (Publisher) o;
        return getId().equals(publisher.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
