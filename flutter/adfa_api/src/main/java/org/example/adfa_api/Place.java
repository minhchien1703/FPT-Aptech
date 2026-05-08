package org.example.adfa_api;

public class Place {
    private Long id;
    private String name;
    private double rating;
    private String imageUrl;

    // Tạo Constructor, Getters và Setters
    public Place(Long id, String name, double rating, String imageUrl) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}