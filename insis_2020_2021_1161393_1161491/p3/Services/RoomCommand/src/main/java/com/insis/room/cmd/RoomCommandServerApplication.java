package com.insis.room.cmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class RoomCommandServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomCommandServerApplication.class, args);
	}

}
