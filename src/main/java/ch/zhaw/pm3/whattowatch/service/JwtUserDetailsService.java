package ch.zhaw.pm3.whattowatch.service;

import ch.zhaw.pm3.whattowatch.dao.UserDAO;
import ch.zhaw.pm3.whattowatch.model.ApplicationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JwtUserDetailsService implements UserDetailsService {
    private final UserDAO userDAO;

    @Autowired
    public JwtUserDetailsService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApplicationUser> applicationUser = userDAO.selectUserByUsername(username);
        applicationUser.orElseThrow(() -> new UsernameNotFoundException("The User with the username: " + username + " was not found"));
        return applicationUser.map(ApplicationUser::new).get();
    }

    public UserDetails createUser(ApplicationUser applicationUser) {
        if (userDAO.addUser(applicationUser.getUsername(), applicationUser.getPassword()) == 1) {
            System.out.println("it worked");
        }
        return applicationUser;
    }
}
