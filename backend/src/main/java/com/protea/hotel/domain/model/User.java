package com.protea.hotel.domain.model;

/**
 * Registered user of the hotel reservation system.
 * Self-registration captures personal details and the system generates
 * a unique username and secure password.
 */
public class User {
    private final Long id;
    private String fullName;
    private String email;
    private String phone;
    private String governmentId;
    private String bankAccount;
    private String username;
    private String password;

    public User(Long id, String fullName, String email, String phone,
                String governmentId, String bankAccount,
                String username, String password) {
        // At minimum, either a phone number or an email address is mandatory.
        boolean hasEmail = email != null && !email.isBlank();
        boolean hasPhone = phone != null && !phone.isBlank();
        if (!hasEmail && !hasPhone) {
            throw new IllegalArgumentException("Either a phone number or an email address is required");
        }
        if (hasEmail && !isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (hasPhone && !isValidPhone(phone)) {
            throw new IllegalArgumentException("Invalid phone format");
        }
        this.id = id;
        this.fullName = (fullName == null) ? "" : fullName.trim();
        this.email = hasEmail ? email.trim() : null;
        this.phone = hasPhone ? phone.trim() : null;
        this.governmentId = (governmentId == null || governmentId.isBlank()) ? null : governmentId.trim();
        this.bankAccount = (bankAccount == null || bankAccount.isBlank()) ? null : bankAccount.trim();
        this.username = username;
        this.password = password;
    }

    private static boolean isValidEmail(String email) {
        String e = email.trim();
        int at = e.indexOf('@');
        int dot = e.lastIndexOf('.');
        return at > 0 && dot > at + 1 && dot < e.length() - 1;
    }

    private static boolean isValidPhone(String phone) {
        String p = phone.trim().replaceAll("[\\s\\-()]", "");
        if (p.startsWith("+")) p = p.substring(1);
        return p.matches("\\d{7,15}");
    }

    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getGovernmentId() { return governmentId; }
    public String getBankAccount() { return bankAccount; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
}