package com.dictionaryapp.config;

import com.dictionaryapp.model.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSession {

    private Long id;

    private String username;


    public void login(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }

    public boolean isUserLoggedIn() {
        return id != null;
    }

    public void logout() {
        this.id = null;
        this.username = null;
    }

    public Long getId() {
        return id;
    }

    public UserSession setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserSession setUsername(String username) {
        this.username = username;
        return this;
    }
}
