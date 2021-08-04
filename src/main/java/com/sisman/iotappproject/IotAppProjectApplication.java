package com.sisman.iotappproject;

import com.sisman.iotappproject.resource.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IotAppProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotAppProjectApplication.class, args);
	}

	@Bean
	public DeviceDataResource getDeviceDataResource(){
		return new DeviceDataResource();
	}

	@Bean
	public LoginResource getLoginResource(){
		return new LoginResource();
	}

	@Bean
	public HomeResource getHomeResource(){
		return new HomeResource();
	}

	@Bean
	public AlarmResource getAlarmResource(){
		return new AlarmResource();
	}

	@Bean
	public DeviceResource getDeviceResource(){ return new DeviceResource(); }

}
