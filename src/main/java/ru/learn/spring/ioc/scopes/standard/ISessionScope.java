package ru.learn.spring.ioc.scopes.standard;

/**
 * Интерфейс бина
 *
 * @since 08.05.2022
 */
public interface ISessionScope
{
	int getCurrentCounter();
	RequestScope getRequestScope();
}
