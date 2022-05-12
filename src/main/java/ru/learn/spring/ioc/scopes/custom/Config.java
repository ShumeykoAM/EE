package ru.learn.spring.ioc.scopes.custom;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Для BeanFactoryPostProcessor и BeanPostProcessor следует использовать статический метод создания бина PostProcessor,
 *   что бы он первым создался
 *
 * @since 10.05.2022
 */
@Configuration
public class Config
{
	@Bean
	public static BeanFactoryPostProcessor myOwnScopeBeanPostProcessor()
	{
		return new MyOwnScopeBeanFactoryPostProcessor();
	}
}
