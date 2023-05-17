package twitter.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthenticationResponse {

  @JsonProperty("token_type")
  private String tokenType;
  @JsonProperty("access_token")
  private String accessToken;
}
