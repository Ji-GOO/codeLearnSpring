package com.jigoo.security;

import com.jigoo.domain.MemberVO;
import com.jigoo.mapper.MemberMapper;
import com.jigoo.security.domain.CustomUser;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

    @Setter(onMethod_ = @Autowired)
    private MemberMapper memberMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        log.warn("Load User By UserName : " + s);

        // userName means userid
        MemberVO vo = memberMapper.read(s);

        log.warn("queried by member mapper : " + vo);

        return vo == null ? null : new CustomUser(vo);
    }
}
