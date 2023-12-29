package gdsc.mini.runaway.Dto;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class AuthMember extends User {
    private String name;
    private Long id;

    public AuthMember(Collection<? extends GrantedAuthority> authorities, Long id, String name){
        super(id.toString(), "", authorities);
        this.name = name;
        this.id = id;
    }
}
