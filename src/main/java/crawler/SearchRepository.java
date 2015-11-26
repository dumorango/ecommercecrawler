package crawler;


import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SearchRepository {

	@Autowired
	private StringRedisTemplate redisTemplate;
	
	public void save(String query,String productsJson) {
	    redisTemplate.opsForValue().set(query, productsJson);
	    redisTemplate.expire(query, 5, TimeUnit.MINUTES);
    }
	
	public String get(String query) {
	    return redisTemplate.opsForValue().get(query);
    }
}
