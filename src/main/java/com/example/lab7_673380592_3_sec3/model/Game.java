package com.example.lab7_673380592_3_sec3.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String genre;

    private String platform;

    private Double rating;

    private LocalDate releaseDate;

    private Double price;

    private String discountType;

    @Transient
    private Double finalPrice;

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    // ใช้สำหรับแสดงชื่อโปรโมชั่นใน list.html
    public String getDiscountName() {

        if (discountType == null) {
            return "ราคาปกติ";
        }

        if ("STUDENT".equalsIgnoreCase(discountType)) {
            return "ส่วนลดนักศึกษา (10%)";
        }

        if ("SEASONAL".equalsIgnoreCase(discountType)) {
            return "ส่วนลดเทศกาล (20%)";
        }

        return "ราคาปกติ (0%)";
    }
}