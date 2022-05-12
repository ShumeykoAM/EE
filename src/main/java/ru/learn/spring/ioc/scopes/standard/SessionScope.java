package ru.learn.spring.ioc.scopes.standard;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * Объект живущий в рамках http сессии, его можно инжектить в синглтоны и бины с другими скоупами
 *
 * @since 08.05.2022
 */
@Component
//proxyMode - используемая технология проксирования, необходима для ижектирования в более долгоживущие бины
@Scope(value = "session", proxyMode = ScopedProxyMode.INTERFACES)
public class SessionScope implements ISessionScope
{
	private static int counter = 0;

	@Getter
	private final int currentCounter;

	@Getter
	@Autowired
	RequestScope requestScope;

	public SessionScope()
	{
		counter++;
		currentCounter = counter;
	}
}
