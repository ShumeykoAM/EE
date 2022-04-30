package ru.learn;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMain
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestBean testBean = context.getBean("testBean", TestBean.class);
		System.out.println(testBean.getName());
		context.close();
	}
}
