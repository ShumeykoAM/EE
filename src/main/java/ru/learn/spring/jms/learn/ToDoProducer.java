package ru.learn.spring.jms.learn;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @since 28.10.2021
 */
@Component
@AllArgsConstructor
public class ToDoProducer
{
	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendTo(String dest, String mes)
	{

	}

}
