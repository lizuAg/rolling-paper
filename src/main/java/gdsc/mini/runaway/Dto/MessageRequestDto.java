package gdsc.mini.runaway.Dto;

import gdsc.mini.runaway.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageRequestDto {
    private String content;
    private Member receiver;
}
