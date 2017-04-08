package pl.workout.kowalczyk.com.app.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.workout.kowalczyk.com.app.dao.user.UserDetailsDao;
import pl.workout.kowalczyk.com.app.model.BO.security.Role;
import pl.workout.kowalczyk.com.app.services.impl.ModelServiceImpl;
import pl.workout.kowalczyk.com.app.services.user.UserDetailsService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by JK on 2016-12-18.
 */
@Service
public class UserDetailsServiceImpl extends ModelServiceImpl<pl.workout.kowalczyk.com.app.model.BO.user.UserDetails> implements UserDetailsService {

    @Autowired
    public UserDetailsServiceImpl(UserDetailsDao baseDao) {
        super(baseDao);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        pl.workout.kowalczyk.com.app.model.BO.user.UserDetails userDetails = getByLogin(s);
        return new User(userDetails.getLogin(), userDetails.getHashedPassword(), userDetails.isEnabled(), userDetails.isAccountNonExpired(), userDetails.isCredentialsNonExpired(),
                userDetails.isAccountNonLocked(), buildUserAuthority(userDetails.getRoles()));
    }

    private List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {
        return userRoles.stream().map(userRole -> new SimpleGrantedAuthority(userRole.getRoleType().name())).collect(Collectors.toList());
    }

    @Override
    public pl.workout.kowalczyk.com.app.model.BO.user.UserDetails getByLogin(String login) {
        return ((UserDetailsDao) getBaseDao()).getByLogin(login);
    }
}
