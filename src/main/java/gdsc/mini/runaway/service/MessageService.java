package gdsc.mini.runaway.service;

import gdsc.mini.runaway.Dto.MessageRequestDto;
import gdsc.mini.runaway.Dto.MessageResponseDto;
import gdsc.mini.runaway.entity.Member;
import gdsc.mini.runaway.entity.Message;
import gdsc.mini.runaway.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public ResponseEntity<?> getReceivedMsgList(Member member){
        List<MessageResponseDto> list =  messageRepository.findAllByTo(member).stream().map(MessageResponseDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<?> getSentMsgList(Member member){
        List<MessageResponseDto> list = messageRepository.findAllByFrom(member).stream().map(MessageResponseDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(list);
    }

    public ResponseEntity<?> getMessage(Member member, Long msgId) {
        Message msg = messageRepository.findById(msgId).orElseThrow(null);
        if(msg.getTo().equals(member)){

        }else if(msg.getFrom().equals(member)){

        }
        else{
            return ResponseEntity.status(403).body("허가되지 않은 사용자입니다.");
        }
        MessageResponseDto responseDto = new MessageResponseDto(msg.getContent(), msg.getFrom().getName());
        return ResponseEntity.ok(responseDto);
    }


    public ResponseEntity<?> postMessage(Member member, MessageRequestDto requestDto){
        Message msg = Message.builder()
                .content(requestDto.getContent())
                .from(member)
                .to(requestDto.getReceiver())
                .build();
        messageRepository.save(msg);

        MessageResponseDto responseDto = new MessageResponseDto(msg.getContent(), member.getName());
        return ResponseEntity.ok(responseDto);
    }
}
