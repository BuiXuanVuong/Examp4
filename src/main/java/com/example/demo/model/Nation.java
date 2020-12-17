package com.example.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nation")
public class Nation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    private String nation;



    @OneToMany(targetEntity = City.class)
    private List<City> cityList;

    public Nation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
