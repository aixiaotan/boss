package org.boss.hong.redis;

import org.boss.hong.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RedisTest {
	
	@Autowired
	private RedisUtil redisUtil;
	
	@Ignore
	@Test
	public void testSet() {
		System.out.println(redisUtil.set("haha", "这是一个测试"));
	}
	
	@Ignore
	@Test
	public void testGet() {
		System.out.println(redisUtil.get("haha"));
	}
}
