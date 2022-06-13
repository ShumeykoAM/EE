package ru.learn.spring.ioc.javabasedconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:message.properties")
@ComponentScan("ru.learn.spring.ioc.javabasedconfig")
/**
 * @Import() добавляем классы конфигурации
 * @ImportResource() Добавляем xml конфигурацию
 *
 *Если если будем запускать с другим профилем как расписано здесь: {@link ru.learn.spring.LearnApplication#nameProfile}
 *   то нужно описать еще одну конфигурацию с соответствующим профилем
 */
@Profile("default") //По умолчанию профиль отсутствует, то есть конфигурация доступна всем профилям
public class JavaBasedConfigurationExample
{
	//загружаем ресурсы из PropertySource
	@Value("${kot.example.name}")
	String name;

	@Autowired
	private Environment environment;

	@Bean
	@Qualifier("kotsName")
	public String getKotsName(@Value("${kot.example.name}") String kotsName)
	{
		String nKot = environment.getProperty("kot.example.name", String.class);
		return kotsName;
	}

	@Bean
	@Lazy
	@DependsOn("kotsName")
	public String getKotsSurname()
	{
		return "нет";
	}
}
