package ru.learn.spring.ioc.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Слушатель события TypeOneEvent
 */
@Component
public class TypeOneEventListener1 implements ApplicationListener<TypeOneEvent>
{
	@Override
	public void onApplicationEvent(TypeOneEvent event)
	{

	}
}
