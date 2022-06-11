package ru.learn.spring.ioc.factory.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanFactoryConfig
{
	@Bean(name = "messageDigestSHA1")
	MessageDigestFactoryBean SHA1MessageDigestFactoryBean()
	{
		return new MessageDigestFactoryBean("SHA1");
	}

	@Bean(name = "messageDigestMD5")
	MessageDigestFactoryBean MD5MessageDigestFactoryBean()
	{
		return new MessageDigestFactoryBean("MD5");
	}
}
