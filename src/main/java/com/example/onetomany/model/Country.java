package com.example.onetomany.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long countryId;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cid",referencedColumnName = "countryId")
    private List<City>cities;


}
