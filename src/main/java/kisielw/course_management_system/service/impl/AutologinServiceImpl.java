package kisielw.course_management_system.service.impl;

import kisielw.course_management_system.service.AutologinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AutologinServiceImpl implements AutologinService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public void autologin(String username) {

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        userDetails,
                        userDetails.getPassword(),
                        userDetails.getAuthorities());

        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
            log.info("Successfully autologin user with username " + username);
        }

    }
}
