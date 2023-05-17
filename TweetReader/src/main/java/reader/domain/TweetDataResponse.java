package reader.domain;

import lombok.Data;

@Data
public class TweetDataResponse {

  private long id;
  private String createdAt;
  private String text;
  private String authorId;
  private String tweetId;
}
