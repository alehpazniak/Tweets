package reader.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reader.domain.TweetDataResponse;

@Repository
public interface TweetDataResponseRepository extends JpaRepository<TweetDataResponse, Long> {

  @Query(value = "select * from Tweet t where t.author_id = ?1",
      nativeQuery = true)
  List<TweetDataResponse> findTweetsByAuthorId(String id);
}
