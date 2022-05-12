package ru.learn.spring.ioc.scopes.custom;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.Random;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @since 10.05.2022
 */
@Component
@Scope(value = "myOwnScope", proxyMode = ScopedProxyMode.INTERFACES)
public class MyOwnScope implements IMyOwnScope
{
	@Override
	public int getI()
	{
		return new Random().nextInt();
	}

	@PostConstruct
	public void construct()
	{

	}

	@PreDestroy
	public void destroy()
	{

	}
}
