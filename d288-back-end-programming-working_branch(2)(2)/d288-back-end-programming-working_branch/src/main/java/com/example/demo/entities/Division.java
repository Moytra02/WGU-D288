package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "divisions")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id", nullable = false)
    private Long id;

    @Column(name = "division", nullable = false)
    private String division_name;

    @Column(name = "create_date", nullable = false)
    @CreationTimestamp
    private Date create_date;

    @Column(name = "last_update", nullable = false)
    @UpdateTimestamp
    private Date last_update;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_ID", nullable = false, insertable = false, updatable = false)
    private Country country;

    @Column(name = "country_ID", nullable = false)
    private Long country_id;
    public void setCountry(Country country) {
        setCountry_id(country.getId());
        this.country = country;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "division")
    private Set<Customer> customers = new HashSet<>();

}