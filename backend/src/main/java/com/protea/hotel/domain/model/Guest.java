package com.protea.hotel.domain.model;

/**
 * Guest entity.
 */
public class Guest {
    private final Long id;
    private String fullName;
    private String email;
    private String phone;

    public Guest(Long id, String fullName, String email, String phone) {
        if (fullName == null || fullName.isBlank()) throw new IllegalArgumentException("Guest name is required");
        if (email == null || !email.contains("@")) throw new IllegalArgumentException("Valid email is required");
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}