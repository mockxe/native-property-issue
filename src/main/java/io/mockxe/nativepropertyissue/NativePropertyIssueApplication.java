package io.mockxe.nativepropertyissue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ConfigProps.class)
public class NativePropertyIssueApplication {

	public static void main(String[] args) {
		SpringApplication.run(NativePropertyIssueApplication.class, args);
	}

}
