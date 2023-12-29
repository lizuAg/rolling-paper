package gdsc.mini.runaway.controller;

import gdsc.mini.runaway.Dto.LoginRequestDto;
import gdsc.mini.runaway.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto requestDto) {
        return memberService.login(requestDto);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout() {
        return null;
    }
}
