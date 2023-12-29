package gdsc.mini.runaway.service;

import gdsc.mini.runaway.Dto.LoginRequestDto;
import gdsc.mini.runaway.Dto.LoginResponseDto;
import gdsc.mini.runaway.entity.Member;
import gdsc.mini.runaway.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final TokenProvider tokenProvider;

    public ResponseEntity<?> login(LoginRequestDto requestDto) {
        Member member = memberRepository.findById(requestDto.getId()).orElseThrow(null);
        if(requestDto.getPassword().equals(member.getPassword())){
            LoginResponseDto responseDto = tokenProvider.generateToken(member.getId(), member.getName());
            return ResponseEntity.ok(responseDto);
        }else{
            return ResponseEntity.status(401).build();
        }
    }
}
