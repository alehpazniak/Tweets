package twitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import twitter.domain.TweetDataResponse;

@Repository
public interface TweetDataResponseRepository extends JpaRepository<TweetDataResponse, Long> {

}
