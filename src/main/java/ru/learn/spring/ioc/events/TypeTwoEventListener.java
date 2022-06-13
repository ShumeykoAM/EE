package ru.learn.spring.ioc.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Слушатель события другого типа TypeTwoEvent
 *
 * @since 13.06.2022
 */
@Component
public class TypeTwoEventListener implements ApplicationListener<TypeTwoEvent>
{
	@Override
	public void onApplicationEvent(TypeTwoEvent event)
	{

	}
}
