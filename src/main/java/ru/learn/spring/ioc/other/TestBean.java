package ru.learn.spring.ioc.other;

import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class TestBean
{
	private String name;
	private AdditionalClass additionalClass;

	@ConstructorProperties({"realName", "realAdditionalClass"})//обычно имена такие же как в конструкторе
	public TestBean(String name, AdditionalClass additionalClass)
	{
		this.name = name;
		this.additionalClass = additionalClass;
	}

	public static TestBean createInstance()
	{
		return new TestBean("from construct", null);
	}
}
