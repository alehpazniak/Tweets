package reader.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reader.domain.TweetDataResponse;
import reader.repository.TweetDataResponseRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReaderService {

  private final TweetDataResponseRepository tweetDataResponseRepository;

  public List<TweetDataResponse> getAllTweets() {
    return tweetDataResponseRepository.findAll();
  }

  public List<TweetDataResponse> getTweetsByClientId(final String id) {
    return tweetDataResponseRepository.findTweetsByAuthorId(id);
  }

}
