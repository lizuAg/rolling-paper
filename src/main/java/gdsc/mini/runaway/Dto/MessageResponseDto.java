package gdsc.mini.runaway.Dto;

import gdsc.mini.runaway.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageResponseDto {
    private String content;
    private String sender;

    public MessageResponseDto(Message msg) {
        this.content = msg.getContent();
        this.sender = msg.getFrom().getName();
    }
}