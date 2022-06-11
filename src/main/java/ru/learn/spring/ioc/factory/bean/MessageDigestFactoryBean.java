package ru.learn.spring.ioc.factory.bean;

import org.springframework.beans.factory.FactoryBean;

import java.security.MessageDigest;

/**
 * Вместо объявления бина класса можно объявить бин FactoryBean этого класса
 *   и кастомным образом создавать бины этого класса при внедрении
 *
 * @since 11.06.2022
 */
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>
{
	private final String type;
	private MessageDigest messageDigest;

	public MessageDigestFactoryBean(String type)
	{
		this.type = type;
	}

	@Override
	public MessageDigest getObject() throws Exception
	{
		if (messageDigest == null)
			messageDigest = MessageDigest.getInstance(type);

		return messageDigest;
	}

	@Override
	public Class<MessageDigest> getObjectType()
	{
		return MessageDigest.class;
	}

	/**
	 * Если поставить false, то метод getObject будет вызываться каждый раз при внедрении бина
	 */
	@Override
	public boolean isSingleton()
	{
		return true;
	}
}
