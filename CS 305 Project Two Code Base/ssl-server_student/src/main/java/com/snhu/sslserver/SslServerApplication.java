package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}

@RestController
class ServerController {
	@RequestMapping("/hash")
	public String myHash() {
		String data = "Hello Jeffrey!";
		// hash data with sha256
		data = data + " : " + SHA256Hash.hash(data);

		return "<p>data:" + data;
	}
}
