package gdsc.mini.runaway.service;


import gdsc.mini.runaway.Dto.AuthMember;
import gdsc.mini.runaway.entity.Member;
import gdsc.mini.runaway.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Log4j2
@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Long memberId = Long.parseLong(username);
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()-> new UsernameNotFoundException("user를 찾을 수 없습니다."));

        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        AuthMember authMember = new AuthMember(
                authorities,
                member.getId(),
                member.getName()
        );
        return authMember;
    }
}

