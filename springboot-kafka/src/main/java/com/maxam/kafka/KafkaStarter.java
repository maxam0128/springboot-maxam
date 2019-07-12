package com.maxam.kafka;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fanjinlong
 * @date 2019-07-11 17:47
 **/
@SpringBootApplication
public class KafkaStarter {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(KafkaStarter.class);
		AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}
}
