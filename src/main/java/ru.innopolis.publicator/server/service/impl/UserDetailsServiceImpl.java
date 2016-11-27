package ru.innopolis.publicator.server.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.innopolis.publicator.server.entity.Role;
import ru.innopolis.publicator.server.repository.UserRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ru.innopolis.publicator.server.entity.User user = null;
        try {
            user = userRepository.findByLogin(username.trim());
        } catch (SQLException e) {
            logger.error(e.getMessage(),e);
        }
        if (user == null) {
            throw new UsernameNotFoundException("Пользователь с таким логином не найден");
        }
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        User securityUser = new User(user.getLogin(),user.getPassword(), true, true, true, true, authorities);

        return securityUser;
    }
}
