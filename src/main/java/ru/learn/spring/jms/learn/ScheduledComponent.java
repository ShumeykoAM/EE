package ru.learn.spring.jms.learn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @since 21.10.2021
 */
@Component
public class ScheduledComponent
{
	@Autowired
	private JmsTemplate jmsTemplate;

	//Можно получить аргументы приложения, передать нужно в виде --аргумент пар1 пар2
	@Autowired
	private ApplicationArguments applicationArguments;

	@Scheduled(fixedRate = 1000)
	public void sendMes()
	{

		if (applicationArguments.containsOption("enabled"))
		{
			try
			{
				jmsTemplate.send("tacocloud.order.queue",
					session -> session.createObjectMessage("JMS message"));
			}
			catch (Exception e)
			{
				throw e;
			}
		}

		System.out.println("scheduled");
	}
}
