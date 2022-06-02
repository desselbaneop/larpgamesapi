package ywa.interactive.larpgamesapi.security.JWT;

import ywa.interactive.larpgamesapi.models.entities.UserConsultDTO;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserJWT extends UserConsultDTO {
    private String token;

    @Builder(builderMethodName = "jwtUserJwtBuilder")
    public UserJWT(String username, String avatar, String rol, String token) {
        super(username, avatar, rol);
        this.token = token;
    }
}
