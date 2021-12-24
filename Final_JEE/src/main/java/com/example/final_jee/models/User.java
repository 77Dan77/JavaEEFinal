package com.example.final_jee.models;

import javax.persistence.*;
import java.util.List;

@Table(name = "users", indexes = {
        @Index(name = "users_login_key", columnList = "login", unique = true)
})
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "login", nullable = false, length = 50)
    private String login;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

//    @OneToMany(mappedBy = "user")
//    private List<Goods> goods;
//
//    @OneToMany(mappedBy = "user")
//    private List<Comments> comments;
//
//    @OneToOne(mappedBy = "user")
//    private UserInfo userInfo;
//
//    @ManyToOne
//    @JoinColumn(name = "role_id")
//    private UserRole role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}