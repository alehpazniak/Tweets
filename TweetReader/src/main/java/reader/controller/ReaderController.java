package reader.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reader.domain.TweetDataResponse;
import reader.service.ReaderService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/read")
public class ReaderController {

  private final ReaderService readerService;

  @GetMapping
  public List<TweetDataResponse> getAllTweets() {
    return readerService.getAllTweets();
  }

  @GetMapping("/{id}")
  public List<TweetDataResponse> getTweetsByClientId(@PathVariable(value = "id") String id) {
    return readerService.getTweetsByClientId(id);
  }
}
