package ru.learn.spring;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@SpringBootApplication(exclude = ActiveMQAutoConfiguration.class)
@EnableScheduling
@EnableJms
public class LearnApplication implements ApplicationRunner, CommandLineRunner

{
	public static void main(String[] args)
	{
		SpringApplication.run(LearnApplication.class, args);
	}

	/**
	 * что бы задать свойство
	 *  в командной строке: --data.server="from command line"
	 *  в переменной среды: SPRING_APPLICATION_JSON='{ "data":{"server":"form environment"}}'
	 *  .... куча мест от куда может тянуться конфиг
	 */
	@Value("${data.server}")
	private String someConfigValue;

	/**
	 * Что бы активировать профиль и тянуть конфиг из профильного файла properties (yml) нужно задать переменную
	 * в командной строке
	 * --spring.profiles.active=prod
	 * или задать переменную среды SPRING_PROFILES_ACTIVE
	 * еще можно через @ActiveProfiles или ConfigurableEnvironment#setActiveProfiles()
	 */
	@Value("${profile.name}")
	private String nameProfile;

	@Autowired
	private ConfigProperties configProperties;

	@Getter
	@Setter
	@Component
	@ConfigurationProperties(prefix = "myapp.custom")
	@JsonComponent
	public static class ConfigProperties
	{
		private String prop;
		private String propName;
		private String propSome;

		@Override
		public String toString()
		{
			return prop + "; " + propName + "; " + propSome;
		}
	}

	@Override
	public void run(ApplicationArguments args) throws Exception
	{
		LogFactory.getLog(this.getClass()).info("data.server = " + someConfigValue);
		LogFactory.getLog(this.getClass()).info("profile.name = " + nameProfile);
		LogFactory.getLog(this.getClass()).info(configProperties);
	}

	@Override
	public void run(String... args) throws Exception
	{

	}
}
