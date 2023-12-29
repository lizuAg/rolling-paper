package gdsc.mini.runaway.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
@AllArgsConstructor
public class LoginResponseDto {
    private String grantType;
    private String accessToken;
}
