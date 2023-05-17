package twitter.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Entity
@Table(name = "Tweet")
public class TweetDataResponse {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "taken_at")
  private long id;
  @Column(name = "taken_at")
  private String createdAt;
  @Column(name = "text")
  private String text;
  @Column(name = "author_id")
  private String authorId;
  @Column(name = "tweet_id")
  private String tweetId;

  public TweetDataResponse() {
  }
}
