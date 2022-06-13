package ru.learn.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learn.spring.ioc.events.TypeOneEvent;
import ru.learn.spring.ioc.events.TypeTwoEvent;
import ru.learn.spring.ioc.scopes.standard.SingletonScope;
import ru.learn.spring.resources.ExampleWorkWithResources;

/**
 * Пример потокобезопасного инъектирования бинов живущих только во время запроса или только во время сесии в постоянно живущие (singleton) бины
 * и другие примеры
 *
 * http://localhost:8081/ в браузере
 * @since 23.10.2021
 */
@RestController
public class SomeRest
{
	@Autowired
	private SingletonScope singletonScope;

	@Autowired
	private ApplicationEventPublisher publisher;

	@Autowired
	private ExampleWorkWithResources exampleWorkWithResources;

	@Autowired
	@Qualifier("kotsName")
	private String kotsName;

	@GetMapping(path = "/")
	String helloWorld()
	{
		//Публикуем парочку событий, будут обработаны в соответствующих слушателях
		publisher.publishEvent(new TypeOneEvent("one"));
		publisher.publishEvent(new TypeTwoEvent("two"));

		exampleWorkWithResources.work();

		return "Если объект синглтона не 1, то это какой то косяк, номер объекта: " + singletonScope.getCurrentCounter() + "<br/>"
			+ "номер объекта сессии: " + singletonScope.getSessionScope().getCurrentCounter()
			+ " в него заинжектен объект запроса номер: " + singletonScope.getSessionScope().getRequestScope().getCurrentCounter()
			+ ", поле объекта с кастомным скоупом не доступно, так как объект - это прокси, значение: " + singletonScope.getSessionScope().getRequestScope().ccStrRepresentation + "<br/>"

			+ "номер объекта запроса: " + singletonScope.getRequestScope().getCurrentCounter()
			+ " в него заинжектен объект сессии номер: " + singletonScope.getRequestScope().getSessionScope().getCurrentCounter();
	}
}
