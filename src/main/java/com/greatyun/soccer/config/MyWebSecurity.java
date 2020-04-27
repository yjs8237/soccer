package com.greatyun.soccer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MyWebSecurity  extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();  //csrf enable 되어 있으면 ajax call 403 에러가 발생한다.
        http.authorizeRequests().antMatchers("/static/** , /js/** , /css/** , /member/** , /admin/** , /join/** , /login/** , /app/**").permitAll();
        http.authorizeRequests()
                .antMatchers("/ajax/**").permitAll()
                .antMatchers("/manage/**").hasAnyRole("ADMIN,MANAGER,PARTNER,SUPER,EMPLOYEE")
                .and()
                //.formLogin().loginPage("/login")
                    .formLogin()
                    .defaultSuccessUrl("/manage")
                    .failureUrl("/login?error")
                .and()
                    .logout().logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                .and()
                    .authorizeRequests()
                    .antMatchers("/api/**").hasRole("RESTAPI")
                .and()
                    .httpBasic()
                .and()
                    .authenticationProvider(customAuthenticationProvider);
        ;

    }

    /*
    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("apiuser").password("apiuser2018").roles("USER").build());
        manager.createUser(users.username("greatyun").password("Jsyun0415!").roles("USER", "ADMIN").build());
        return manager;

    }
    */

    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(adminService).passwordEncoder(passwordEncoder());
    }

     */


}
