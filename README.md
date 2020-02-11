# SpringCacheWithRedis


## There are 2 config files: Both have separate cache managers one for Redis and One for Inmemory
(We need to set one a primary mandatorily).
1. InmemoryCacheConfig
1. RedisCacheConfig


## The redis config is in `application.properties` 
1. spring.cache.type=redis
2. spring.redis.host=127.0.0.1
3. spring.redis.port=6379

## For connection pooling it uses apache commons pool2 so u will need to set the dependency:
`
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-pool2</artifactId>
		</dependency>
`

* All the data in redis is accessed using Spring Data , as simple entity bean, however we are not mandated do it.
* Cache Eviction is Scheduled, can be made conditional @CacheEvict has much more options and we can liverage them.
* By default Spring Data Redis uses `lettuce` internally.

## Redis Server
In Manjaro linux we use pacman `pacman -S redis`
1. Start irt using `systemctl start redis`
1. Test it using `redis-cli` -> Will allow u access to loacal redis -> `ping` should reply -> "pong"

For others download redis binary and run the `.sh` file.
