package org.list4team.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cargo;
    private String email;
    private String tokem;
    @ManyToMany()
    private List<Task> tasks = null;

    public User(Integer id, String nome, String cargo, String email, String tokem) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.email = email;
        this.tokem = tokem;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String name) {
        this.nome = name;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTokem() {
        return tokem;
    }

    public void setTokem(String token) {
        this.tokem = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addtask(Task task) {
         tasks.add(task);
    }
}
