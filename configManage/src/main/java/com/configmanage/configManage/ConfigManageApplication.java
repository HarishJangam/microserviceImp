package com.configmanage.configManage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigManageApplication.class, args);
	}

}
