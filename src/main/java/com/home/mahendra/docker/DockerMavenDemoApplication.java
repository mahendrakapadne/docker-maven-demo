package com.home.mahendra.docker;

import com.home.mahendra.docker.config.DefaultProfileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
@ComponentScan
@SpringBootApplication
@EnableConfigurationProperties(LiquibaseProperties.class)
public class DockerMavenDemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DockerMavenDemoApplication.class);

	private final Environment env;

	public DockerMavenDemoApplication(Environment env) {
		this.env = env;
	}

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(DockerMavenDemoApplication.class);
		DefaultProfileUtil.addDefaultProfile(app);
		Environment env = app.run(args).getEnvironment();
		log.info("\n----------------------------------------------------------\n\t" +
						"Application '{}' is running! Access URLs:\n\t" +
						"Local: \t\thttp://localhost:{}\n\t" +
						"External: \thttp://{}:{}\n\t" +
						"Profile(s): \t{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"),
				env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"),
				env.getActiveProfiles());
	}
}
