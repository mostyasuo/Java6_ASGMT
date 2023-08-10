package model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Accounts")
@Data
public class Account implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Fullname")
    private String fullName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Photo")
    private String Photo;

    @Column(name = "Address")
    private String address;
      @Column(name = "activated")
    private Boolean activated;
   }
