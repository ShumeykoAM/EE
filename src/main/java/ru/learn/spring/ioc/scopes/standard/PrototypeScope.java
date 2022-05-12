package ru.learn.spring.ioc.scopes.standard;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @since 13.05.2022
 */
@Component
@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrototypeScope
{
	public static int counter = 0;

	public int getCounter()
	{
		return counter;
	}

	@PostConstruct
	public void construct()
	{
		counter++;
	}

	@PreDestroy
	public void destroy()
	{

	}
}
