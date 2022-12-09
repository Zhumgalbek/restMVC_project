package com.peaksoft.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "companies")
public class Company {
    @Id
    @SequenceGenerator(name = "company_seq", sequenceName = "company_seq", allocationSize = 1)
    @GeneratedValue(generator = "company_seq", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500)
    private String companyName;

    @Column(length = 500)
    private String locatedCountry;

    @Column
    private int student = 0;

    public Company(String companyName, String locatedCountry) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
    }

    @OneToMany(cascade = ALL, fetch = LAZY, mappedBy = "company")
    private List<Course> courses;

    public void addCourse(Course course) {
        if (courses == null) courses = new ArrayList<>();
        courses.add(course);
    }

    public void plus() {
        student++;
    }

    public void minus() {
        student--;
    }
    @OneToMany(cascade = {ALL}, fetch = LAZY, mappedBy = "company")
    private List<Group> groups;
    public void addGroup(Group group){
        if (groups==null){
            groups=new ArrayList<>();
        }
        groups.add(group);
    }
}
