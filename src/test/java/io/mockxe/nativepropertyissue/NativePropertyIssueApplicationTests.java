package io.mockxe.nativepropertyissue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

@SpringBootTest
class NativePropertyIssueApplicationTests {

	@Autowired
	ConfigProps configProps;

	@Test
	void contextLoads() {
	}

	@Test
	void propertyBinding() {
		assert configProps.getMediaType().equals(MediaType.APPLICATION_JSON);
	}

}
