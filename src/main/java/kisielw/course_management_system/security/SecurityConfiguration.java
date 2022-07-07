package kisielw.course_management_system.security;

import kisielw.course_management_system.security.CustomSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/h2-console/**", "/registration")
                .permitAll()
                .antMatchers("/admin/**")
                .hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/lecturer/**")
                .hasAnyAuthority("ROLE_HOST")
                .antMatchers("/student/**")
                .hasAnyAuthority("ROLE_STUDENT")
                .antMatchers("/**")
                .hasAnyRole("ADMIN", "HOST", "STUDENT")
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(customSuccessHandler)
                .failureUrl("/login")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .and()
                .headers().frameOptions().disable();
    }

}
