package com.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Set;

import static javax.persistence.CascadeType.REMOVE;

@Entity
@Getter
@Setter
@Table(name = "department")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER ,mappedBy="department", cascade = REMOVE )
    private Set<Employees> employee;

    @Override
    public String toString() {
        return "Departments{" +
                "id=" + id +
                ", name='" + name + '\''+'}';
    }
}
