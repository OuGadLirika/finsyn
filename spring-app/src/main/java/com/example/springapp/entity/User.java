package com.example.springapp.entity;

import lombok.*;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "USER_")
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(unique = true, nullable = false)
    private String email;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 512)
    private String bio;

    @Column(unique = true, nullable = false)
    private String publicLink;

    @Column
    private String avatarUrl;

    @Column(columnDefinition = "DECIMAL(10,2)")
    private Double balance;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tip> receivedTips;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tip> sentTips;

    public enum Gender {
        MALE, FEMALE
    }
}
