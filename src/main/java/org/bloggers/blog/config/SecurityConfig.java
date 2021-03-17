package org.bloggers.blog.config;

import org.bloggers.blog.config.auth.PrincipalDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity //시큐리티 필터 추가
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipalDetailService principalDetailService;

    @Bean
    public BCryptPasswordEncoder encodePWD() {
        return new BCryptPasswordEncoder();
    }

    /**
     * security가 대신 로그인해주는데 password를 가로채기 하는데 해당 password가
     * 뭘로 해쉬가 되어 회원가입이 되는지를 알아야
     * 같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음.
     */


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**", "/js/**", "/css/**", "/image/**", "/")
                .permitAll()
                .anyRequest()
                .authenticated()
        .and()
            .formLogin()
            .loginPage("/auth/loginForm")
                //spring security가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인을 해준다.
            .loginProcessingUrl("/auth/loginProc")
            .defaultSuccessUrl("/");
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
