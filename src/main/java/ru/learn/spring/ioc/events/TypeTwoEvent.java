package ru.learn.spring.ioc.events;

import org.springframework.context.ApplicationEvent;

/**
 * Некое другое событие
 */
public class TypeTwoEvent extends ApplicationEvent
{
	public TypeTwoEvent(Object source)
	{
		super(source);
	}
}
