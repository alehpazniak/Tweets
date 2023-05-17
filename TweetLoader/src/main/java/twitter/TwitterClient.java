package twitter;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Mono;
import twitter.configuration.AccountConfiguration;
import twitter.configuration.TwitterConfiguration;
import twitter.domain.AuthenticationResponse;
import twitter.domain.TweetResponse;
import twitter.exception.ClientException;

@Service
public class TwitterClient {

  private final AccountConfiguration accountConfiguration;

  private final WebClient webClient;

  public TwitterClient(final AccountConfiguration accountConfiguration, final Builder builder, final TwitterConfiguration configuration) {
    this.accountConfiguration = accountConfiguration;
    this.webClient = builder
        .baseUrl(configuration.getBaseUrl())
        .build();
  }

  public TweetResponse getTweets(final String id) {
    var accessToken = getToken().getAccessToken();
    return webClient.get().uri("/2/users/{id}/tweets", id)
        .headers(httpHeaders -> httpHeaders.setBearerAuth(accessToken))
        .retrieve()
        .onStatus(HttpStatusCode::isError, response -> Mono.error(new ClientException("Something went wrong")))
        .bodyToMono(TweetResponse.class)
        .block();
  }

  private AuthenticationResponse getToken() {
    return webClient.post()
        .uri("/oauth2/token?grant_type=client_credentials")
        .headers(headers -> headers.setBasicAuth(accountConfiguration.getApiKey(), accountConfiguration.getApiSecretKey()))
        .retrieve()
        .onStatus(HttpStatusCode::isError, response -> Mono.error(new ClientException("Credentials are incorrect")))
        .bodyToMono(AuthenticationResponse.class)
        .block();
  }

}
