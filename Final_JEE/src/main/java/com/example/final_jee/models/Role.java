package com.example.final_jee.models;

import com.example.final_jee.Utils.RoleName;

import javax.persistence.*;
import java.util.List;

@Table(name = "roles", indexes = {
        @Index(name = "roles_name_key", columnList = "name", unique = true)
})
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
//
    @Column(name = "name", nullable = false, length = 50)
    private String name;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "name", nullable = false, length = 50)
//    private RoleName name;

//    @OneToMany(mappedBy = "role")
//    private List<User> users;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "name", nullable = false)
//    private Role roleName;
//    public Long getId() {
//        return id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    public RoleName getName() {
//        return name;
//    }
//
//    public void setName(RoleName name) {
//        this.name = name;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}