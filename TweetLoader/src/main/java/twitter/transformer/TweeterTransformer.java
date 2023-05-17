package twitter.transformer;

import java.util.List;
import java.util.stream.Collectors;
import twitter.domain.TweetDataResponse;
import twitter.domain.TweetResponse.TweetData;

public class TweeterTransformer {

  public List<TweetDataResponse> convertTweets(final List<TweetData> tweets) {
    return tweets.stream()
        .map(this::mapToTweetDataResponse)
        .collect(Collectors.toList());
  }

  private TweetDataResponse mapToTweetDataResponse(final TweetData tweetData) {
    return TweetDataResponse.builder()
        .createdAt(tweetData.getCreatedAt())
        .text(tweetData.getText())
        .authorId(tweetData.getAuthorId())
        .tweetId(tweetData.getId())
        .build();
  }


/*  Conversion for writing to a file
  public TweetDataResponse convertTweets(final List<TwitData> tweets) {
    var tweetDataResponse = new TweetDataResponse();
    tweetDataResponse.setLastTweet(tweets.get(0).getCreatedAt());
    tweetDataResponse.setAuthorId(tweets.get(0).getAuthorId());
    tweetDataResponse.setTweets(getTweets(tweets));
    return tweetDataResponse;
  }

  private List<Tweet> getTweets(final List<TwitData> tweets) {
    return tweets.stream()
        .map(this::getTweet)
        .collect(Collectors.toList());
  }

  private Tweet getTweet(final TwitData twitData) {
    var tweet = new Tweet();
    tweet.setText(twitData.getText());
    return tweet;
  }
*/

}
