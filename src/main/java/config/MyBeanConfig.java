package config;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		"dao",
		"data",
		"main",
		"report",
		"service"
		
})
public class MyBeanConfig {

}
