package ru.learn.spring.ioc.other;

import lombok.Setter;

/**
 * @since 05.05.2022
 */
public class SimpleAccountServiceProxy extends SimpleAccountService
{
	@Setter
	public SimpleAccountService simpleAccountService;
}
