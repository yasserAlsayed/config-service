package com.polrbookshop.configservice;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.apache.sshd.server.Environment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConfigServiceApplicationTests {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void defaultConfigurationAvailable() {
		ResponseEntity<Environment> entity = restTemplate
				.getForEntity("/application/default", Environment.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

}
