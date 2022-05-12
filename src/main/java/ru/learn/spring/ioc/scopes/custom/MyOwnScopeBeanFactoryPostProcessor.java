package ru.learn.spring.ioc.scopes.custom;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.SimpleThreadScope;

/**
 * Пост процессор фабрики регистрации кастомного скоупа
 *
 * @since 10.05.2022
 */
public class MyOwnScopeBeanFactoryPostProcessor implements BeanFactoryPostProcessor
{
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException
	{
		beanFactory.registerScope("myOwnScope", new MyOwnCustomScope());

		//незарегистрированный по умолчанию скоуп спринга для бинов живущих в рамках потока
		beanFactory.registerScope("thread", new SimpleThreadScope());
	}
}
