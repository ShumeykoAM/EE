package ru.learn.spring.ioc.scopes.standard;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * некий синглтон
 *
 * @since 08.05.2022
 */
@Component
//@Scope(value = "singleton") // singleton is default scope
public class SingletonScope
{
	private static int counter = 0;

	@Getter
	@Autowired
	private RequestScope requestScope;

	@Getter
	@Autowired
	private ISessionScope sessionScope;

	@Getter
	private final int currentCounter;

	public SingletonScope()
	{
		++counter;
		currentCounter = counter;
	}
}
