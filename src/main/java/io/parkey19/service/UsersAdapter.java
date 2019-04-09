package io.parkey19.service;

import io.parkey19.model.UserRole;
import io.parkey19.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by parkey19 on 2019. 4. 8..
 */
public class UsersAdapter extends User {

    private Users users;

    public UsersAdapter(Users users) {
        super(users.getUsername(), users.getPassword(), authorities(users.getRoles()));
        this.users = users;
    }

    public static Collection<? extends GrantedAuthority> authorities(List<UserRole> roles) {
        return roles.stream()
                .map(r -> new SimpleGrantedAuthority("ROLE_" + r.name()))
                .collect(Collectors.toSet());
    }

    public Users getUsers() {
        return users;
    }

}
