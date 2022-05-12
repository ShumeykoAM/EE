package ru.learn.spring.ioc.other;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMain
{
	public static void main(String[] args)
	{
		try
		{
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ioc/applicationContext.xml");
			//context.getBeanFactory().registerScope("thread", new SimpleThreadScope()); //можно вместо xml

			TestBean testBean1 = context.getBean("testBean", TestBean.class);
			TestBean alias1 = context.getBean("alias1", TestBean.class);
			TestBean alias2 = context.getBean("alias2", TestBean.class);
			TestBean alias3 = context.getBean("alias3", TestBean.class);
			TestBean alias4 = context.getBean("alias4", TestBean.class);
			TestBean alias5 = context.getBean("alias5", TestBean.class);

			OuterClass.InnerClass innerStatic1 = context.getBean("innerStatic1", OuterClass.InnerClass.class);
			OuterClass.InnerClass innerStatic2 = context.getBean("innerStatic2", OuterClass.InnerClass.class);

			TestBean fromFactoryMethod = context.getBean("fromFactoryMethod", TestBean.class);
			TestBean fromAbstractFactory = context.getBean("fromAbstractFactory", TestBean.class);

			SimpleMovieLister movieLister = context.getBean("movieListener", SimpleMovieLister.class);

			CommandManager manager = context.getBean("commandManager", CommandManager.class);
			manager.process();
			manager.process();
			manager.process();

			CommandManager.Command command = context.getBean("threadBean", CommandManager.Command.class);

			Node node1 = context.getBean("node1", Node.class);

			System.out.println(testBean1.getName());
			context.close();
		}
		catch (Throwable th)
		{
			System.out.println(th);
		}
	}
}
