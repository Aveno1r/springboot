package com.shenxiao;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class Springboot06TliasApplicationTests {

	@Test
	void contextLoads() {
		Map<String,Object> claims = new HashMap<>();
		claims.put("id",1);
		claims.put("username","Tom");

		String jwt = Jwts.builder()
				.setClaims(claims) //自定义内容(载荷)
				.signWith(SignatureAlgorithm.HS256, "itheima") //签名算法
				.setExpiration(new Date(System.currentTimeMillis() + 24*3600*1000)) //有效期
				.compact();

		System.out.println(jwt);
	}
	@Test
	public void parseJwt(){
		Claims claims = Jwts.parser()
				.setSigningKey("itheima")
				.parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwiZXhwIjoxNjc1OTE1MTA0LCJ1c2VybmFtZSI6IlRvbSJ9.a0wCoJ4rBVrWtHU8CpCIbd1vBOckTNr_-BB3yUzUsqo")
				.getBody();
		System.out.println(claims);
	}
}
