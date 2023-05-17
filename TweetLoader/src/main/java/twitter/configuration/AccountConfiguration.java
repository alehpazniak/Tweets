package twitter.configuration;

import java.util.Set;
import lombok.Data;

@Data
public class AccountConfiguration {

  private String apiKey = "5hWAdtK3Da5UBSFxlmcWMl8aE";
  private String apiSecretKey = "aGgeYB5KwgmbpM0c279ih7QBNG1uiCmso0tUAGhvR0aD441XWZ";
  private Set<String> CLIENT_IDS = Set.of("2244994945", "2244994946", "2244994947");

}
