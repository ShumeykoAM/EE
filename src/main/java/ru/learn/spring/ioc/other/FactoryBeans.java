package ru.learn.spring.ioc.other;

public class FactoryBeans
{
	public TestBean createTestBeanInstance()
	{
		return new TestBean("from factory", null);
	}
}
