package twitter.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import twitter.TwitterClient;
import twitter.configuration.AccountConfiguration;
import twitter.domain.TweetDataResponse;
import twitter.domain.TweetResponse.TweetData;
import twitter.repository.TweetDataResponseRepository;
import twitter.transformer.TweeterTransformer;

@RequiredArgsConstructor
@Service
public class TwitterService {

  private final AccountConfiguration accountConfiguration;
  private final TwitterClient twitterClient;
  private final TweeterTransformer tweeterTransformer;
  private final TweetDataResponseRepository tweetDataResponseRepository;

  public void saveToFile(final String path) throws IOException {

    var tweetВфеф = getTweetData();
    var tweetDataResponse = tweeterTransformer.convertTweets(tweetВфеф);

    tweetDataResponseRepository.saveAll(tweetDataResponse);

    /*
    writeToFile(tweetDataResponse, path);
*/
  }

  private List<TweetData> getTweetData() {
    return accountConfiguration.getCLIENT_IDS().stream()
        .map(twitterClient::getTweets)
        .flatMap(tweetResponse -> tweetResponse.getData().stream())
        .toList();
  }
/*
  private void writeToFile(final TweetDataResponse tweetDataResponse, final String path) throws FileNotFoundException {
    var fileName = Path.of(path);
    var pw = new PrintWriter(new FileOutputStream(fileName.toString()));
    pw.println(tweetDataResponse);
    pw.close();
  }
*/

}
