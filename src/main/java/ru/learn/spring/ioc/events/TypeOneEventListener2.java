package ru.learn.spring.ioc.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Еще один слушатель события TypeOneEvent
 */
@Component
public class TypeOneEventListener2 implements ApplicationListener<TypeOneEvent>
{
	@Override
	public void onApplicationEvent(TypeOneEvent event)
	{

	}
}
