package ru.learn.spring.ioc.scopes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learn.spring.ioc.scopes.standard.SingletonScope;

/**
 * Пример потокобезопасного инъектирования бинов живущих только во время запроса или только во время сесии в постоянно живущие (singleton) бины
 *
 * @since 23.10.2021
 */
@RestController
public class SomeRest
{
	@Autowired
	private SingletonScope singletonScope;

	@GetMapping(path = "/")
	String helloWorld()
	{
		return "Если объект синглтона не 1, то это какой то косяк, номер объекта: " + singletonScope.getCurrentCounter() + "<br/>"
			+ "номер объекта сессии: " + singletonScope.getSessionScope().getCurrentCounter()
			+ " в него заинжектен объект запроса номер: " + singletonScope.getSessionScope().getRequestScope().getCurrentCounter()
			+ ", поле объекта с кастомным скоупом не доступно, так как объект - это прокси, значение: " + singletonScope.getSessionScope().getRequestScope().ccStrRepresentation + "<br/>"

			+ "номер объекта запроса: " + singletonScope.getRequestScope().getCurrentCounter()
			+ " в него заинжектен объект сессии номер: " + singletonScope.getRequestScope().getSessionScope().getCurrentCounter();
	}


}
