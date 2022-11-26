package dev.lbelin.forumapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForumAPI implements CommandLineRunner {

	@Override
	public void run(final String... args) throws Exception {
	}

	public static void main(String[] args) {
		SpringApplication.run(ForumAPI.class, args);
	}
}
