package dev.aquashdw.community.config;


import dev.aquashdw.community.infra.CommunityUserDetailsService;
import dev.aquashdw.community.infra.NaverOAuth2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final NaverOAuth2Service naverOAuth2Service;

    public WebSecurityConfig(
            @Autowired CommunityUserDetailsService communityUserDetailsService,
            @Autowired NaverOAuth2Service naverOAuth2Service
    ){
        this.userDetailsService = communityUserDetailsService;
        this.naverOAuth2Service = naverOAuth2Service;

    }

    /*
    * 아래 함수는 사용자의 관리, ID와 pw가 일치하는지 확인하는 곳
    *
    * inMemoryAuthentication()는 메모리상에서 user검증을 하겠다.
    * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService);


    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home/**", "/user/signup/**")
                .anonymous()
                .anyRequest()
                .authenticated()
            .and()
                .formLogin()
                .loginPage("/user/login")
                .defaultSuccessUrl("/home") //스프링부트에서는 로그인을 하면 바로 root페이지로 가도록 되어있다. 그래서 home페이지로 가도록 설정을 한다.
                .permitAll()
            .and()
                .oauth2Login()
                    .userInfoEndpoint()
                    .userService(this.naverOAuth2Service)
                .and()
                    .defaultSuccessUrl("/home")
            .and()
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/home")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .permitAll()
        ;
    }



}
