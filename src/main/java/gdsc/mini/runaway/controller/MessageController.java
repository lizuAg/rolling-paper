package gdsc.mini.runaway.controller;

import gdsc.mini.runaway.Dto.AuthMember;
import gdsc.mini.runaway.Dto.MessageRequestDto;
import gdsc.mini.runaway.entity.Member;
import gdsc.mini.runaway.service.MessageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class MessageController {
    private final MessageService messageService;

    @Operation(summary = "Some API", description = "설명")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "success", description = "성공"),
            @ApiResponse(responseCode = "fail")})
    @GetMapping("/messages/received")
    public ResponseEntity<?> getReceivedMsgList(@RequestHeader String Authorization) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthMember principal = (AuthMember) authentication.getPrincipal();

        Member member = new Member();
        return messageService.getReceivedMsgList(member);
    }

    @GetMapping("/messages/sent")
    public ResponseEntity<?> getSentMsgList(@RequestHeader String Authorization) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthMember principal = (AuthMember) authentication.getPrincipal();

        Member member = new Member();
        return messageService.getSentMsgList(member);
    }

    @GetMapping("/messages/{msg-id}")
    public ResponseEntity<?> getMessage(@RequestHeader String Authorization, @RequestParam Long msgId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthMember principal = (AuthMember) authentication.getPrincipal();

        Member member = new Member();
        return messageService.getMessage(member, msgId);
    }

    @PostMapping("/messages")
    public ResponseEntity<?> post(@RequestHeader String Authorization, @RequestBody MessageRequestDto requestDto)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthMember principal = (AuthMember) authentication.getPrincipal();

        Member member = new Member();
        return messageService.postMessage(member, requestDto);
    }
}