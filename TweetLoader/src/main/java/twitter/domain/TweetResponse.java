package twitter.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;
import lombok.Getter;

@Data
public class TweetResponse {

  @JsonProperty("data")
  private List<TweetData> data;
  @JsonProperty("includes")
  private Includes includes;
  @JsonProperty("meta")
  private Meta meta;

  @Data
  public static class TweetData {

    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("text")
    private String text;
    @JsonProperty("author_id")
    private String authorId;
    @JsonProperty("id")
    private String id;
  }

  @Data
  static class Includes {

    @JsonProperty("users")
    List<User> users;
  }

  @Data
  @Getter
  public class Meta {

    @JsonProperty("result_count")
    private Integer resultCount;
    @JsonProperty("newest_id")
    private String newestId;
    @JsonProperty("oldest_id")
    private String oldestId;
    @JsonProperty("next_token")
    private String nextToken;
  }

}
