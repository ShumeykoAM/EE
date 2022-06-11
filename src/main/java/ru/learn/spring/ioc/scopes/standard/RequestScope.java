package ru.learn.spring.ioc.scopes.standard;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import ru.learn.spring.ioc.scopes.custom.IMyOwnScope;

import java.security.MessageDigest;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Объект живущий в рамках одного http запроса, его можно инжектить в синглтоны и бины с другими скоупами
 *
 * @since 08.05.2022
 */
@Component
//proxyMode - используемая технология проксирования, необходима для ижектирования в более долгоживущие бины
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public abstract class RequestScope
{
	private static int counter = 0;

	private final int currentCounter;

	//!!! Внимание, поля не будут доступны, так как инжектится будет проксирующий класс, а не сам этот объект
	public final String ccStrRepresentation;

	@Getter
	@Autowired
	private ISessionScope sessionScope;

	@Autowired
	private IMyOwnScope myOwnScope;

	@Autowired
	private MessageDigest messageDigestSHA1;

	@Autowired
	@Qualifier("messageDigestMD5")
	private MessageDigest messageDigest;

	public RequestScope()
	{
		counter++;
		currentCounter = counter;
		ccStrRepresentation = "-" + String.valueOf(currentCounter) + "-";
	}

	public String getCurrentCounter()
	{
		int i = getPrototypeScopeBean().getCounter();
		return currentCounter + ":" + i;
	}

	@PostConstruct
	public void postConstruct()
	{
		System.out.println("postConstruct");
	}

	@PreDestroy
	public void preDestroy()
	{
		System.out.println("preDestroy");
	}

	@Lookup
	public abstract PrototypeScope getPrototypeScopeBean();
}
