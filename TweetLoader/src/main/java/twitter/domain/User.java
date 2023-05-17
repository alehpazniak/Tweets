package twitter.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

  @JsonProperty("created_at")
  private String createdAt;
  @JsonProperty("name")
  private String name;
  @JsonProperty("user_name")
  private String userName;
  @JsonProperty("id")
  private String id;


}
