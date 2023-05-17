import java.io.File;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import twitter.service.TwitterService;

@Slf4j
@RequiredArgsConstructor
public class Runner implements CommandLineRunner {

  private final TwitterService twitterService;

  @Override
  public void run(final String... args) throws Exception {
    log.info("EXECUTING : command line runner");
    var filePath = args[0];
    if (validate(filePath)) {
      twitterService.saveToFile(filePath);
    }
    log.info("APPLICATION EXECUTION - COMPLETED");
  }

  private boolean validate(final String filePath) {
    var file = new File(filePath);
    if (!file.isDirectory()) {
      throw new IllegalArgumentException("file path is not exist");
    }
    return true;
  }

}
