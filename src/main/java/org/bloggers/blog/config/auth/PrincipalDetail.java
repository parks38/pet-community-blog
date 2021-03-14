package org.bloggers.blog.config.auth;

import lombok.Getter;
import org.bloggers.blog.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 User Details 타입의 오브젝트를
 * 스프링 시큐리티의 고유한 세션 저장에 저장을 해준다.
 */
@Getter
public class PrincipalDetail implements UserDetails {
    private User user; //composition - 품고있기

    public PrincipalDetail(User user){
        this.user = user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
    // 계정이 만료되지 않았는지 리턴한다. (true: 만료 안됨)
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // 계정이 잠겨있지 않았는지 리턴한다. (true: 잠겨있지 않음)
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //비밀번호가 만료되었는지 리턴
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정이 활성화 (사용가능)인지 리턴
    @Override
    public boolean isEnabled() {
        return true;
    }
    // 계정의 권한을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();
        collectors.add((GrantedAuthority) () -> {
            return "ROLE_" + user.getRole(); //ROLE_USER
        });
        return collectors;
    }
}
