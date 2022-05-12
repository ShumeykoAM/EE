package ru.learn.spring.ioc.scopes.custom;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

/**
 * Реализуем свой собственный синглтон
 *
 * @since 10.05.2022
 */
public class MyOwnCustomScope implements Scope
{
	Map<String, Object> singletons = new HashMap<>();

	@Override
	public Object get(String name, ObjectFactory<?> objectFactory)
	{
		if (!singletons.containsKey(name))
			singletons.put(name, objectFactory.getObject());

		return singletons.get(name);
	}

	@Override
	public Object remove(String name)
	{
		return singletons.remove(name);
	}

	@Override
	public void registerDestructionCallback(String name, Runnable callback)
	{
		//Метод вызовется если есть метод класса бина помеченный @PreDestroy
		//Метод remove и callback нужно вызывать вручную
	}

	@Override
	public Object resolveContextualObject(String key)
	{
		return null;
	}

	@Override
	public String getConversationId()
	{
		return null;
	}
}
