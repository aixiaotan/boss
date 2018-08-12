package org.boss.hong.redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class Redis {

	public static void main(String[] args) {
		JedisShardInfo sharInfo = new JedisShardInfo("140.143.89.173", 6379);
		sharInfo.setPassword("123456");
		   Jedis jedis = new Jedis(sharInfo);
		   String result = jedis.set("name", "zhangsan");
		   System.out.println(result);
		   String name = jedis.get("name");
		   System.out.println(name);
		   jedis.close();
		   
		   test();
	}
	
	public static void test() {
		JedisPoolConfig config = new JedisPoolConfig();
		    config.setMaxIdle(1000);//最大空闲时间
		    config.setMaxWaitMillis(1000); //最大等待时间
		    config.setMaxTotal(500); //redis池中最大对象个数
		    
		    JedisShardInfo sharInfo = new JedisShardInfo("140.143.89.173", 6379);
		    sharInfo.setPassword("123456");
		    List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
		    list.add(sharInfo);
		   ShardedJedisPool pool = new ShardedJedisPool(config, list);
		   ShardedJedis jedis2 = pool.getResource();
		   jedis2.set("haha", "测试");
		   System.out.println(jedis2.get("haha"));
	}
	
	public  ShardedJedis getRedis() {
		JedisPoolConfig config = new JedisPoolConfig();
	    config.setMaxIdle(1000);//最大空闲时间
	    config.setMaxWaitMillis(1000); //最大等待时间
	    config.setMaxTotal(500); //redis池中最大对象个数
	    
	    JedisShardInfo sharInfo = new JedisShardInfo("140.142.89.173", 6379);
	    sharInfo.setPassword("123456");
	    List<JedisShardInfo> list = new ArrayList<JedisShardInfo>();
	    list.add(sharInfo);
	   ShardedJedisPool pool = new ShardedJedisPool(config, list);
	   ShardedJedis jedis2 = pool.getResource();
	   return jedis2;
	}
	
}
