package com.skiatel.spingmongodb.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class UserRequest {
    @Size(max = 100)
    @NotNull(message = "El nombre es requerido")
    private String name;

    @NotNull(message = "El email es requerido")
    @Email
    private String email;

    @NotNull
    @Size(min= 8, max = 20, message = "La Contraseña debe contener entre 8 a 20 caracteres")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
