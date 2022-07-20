package com.alperbozcal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TubisadOdevApplication {

	public static void main(String[] args) {
		SpringApplication.run(TubisadOdevApplication.class, args);
		//DevTools
		System.setProperty("spring.devtools.restart.enabled","true");

		// AWT: JOptionPanel set ayarı
		System.setProperty("java.awt.headless", "false");
	}

}
