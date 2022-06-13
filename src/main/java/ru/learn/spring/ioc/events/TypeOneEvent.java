package ru.learn.spring.ioc.events;

import org.springframework.context.ApplicationEvent;

/**
 * Некое событие
 */
public class TypeOneEvent extends ApplicationEvent
{
	public TypeOneEvent(Object source)
	{
		super(source);
	}
}
