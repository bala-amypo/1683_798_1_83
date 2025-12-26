// package com.example.demo.entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Vendor {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     private boolean active; // <-- make sure this exists

//     // Getters and Setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public boolean isActive() {  // <-- must match what Service calls
//         return active;
//     }

//     public void setActive(boolean active) {
//         this.active = active;
//     }
// }
package com.example.demo.model;

public class Vendor {
    private Long id;
    private String name;
    private String contactEmail;
    private String contactPhone;
    private Boolean active = true;

    public Vendor() {}

    public Vendor(String name, String email, String phone) {
        this.name = name;
        this.contactEmail = email;
        this.contactPhone = phone;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public String getContactEmail() { return contactEmail; }
    public void setContactEmail(String c) { this.contactEmail = c; }

    public String getContactPhone() { return contactPhone; }
    public void setContactPhone(String p) { this.contactPhone = p; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean a) { this.active = a; }
}
