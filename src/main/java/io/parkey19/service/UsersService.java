package io.parkey19.service;

import io.parkey19.model.Users;
import io.parkey19.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by parkey19 on 2019. 4. 8..
 */
@Service
public class UsersService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Users saveAccount(Users users) {
        users.setPassword(this.passwordEncoder.encode(users.getPassword()));
        return this.usersRepository.save(users);
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException(userName));
        return new UsersAdapter(users);
    }
}
