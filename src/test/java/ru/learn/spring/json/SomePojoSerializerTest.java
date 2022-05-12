package ru.learn.spring.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.learn.spring.LearnApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тестируем @JsonComponent связанный с ObjectMapper джексона
 *
 * @since 23.10.2021
 */
@JsonTest
class SomePojoSerializerTest
{
	@Autowired
	LearnApplication learnApplication;

	/**
	 * Благодаря spring-boot-starter-web объект ObjectMapper будет работать с классами @JsonComponent
	 * этот же объект ObjectMapper будет использоваться в RestController
	 */
	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void testSerialize() throws JsonProcessingException
	{
		SomePojo somePojo = new SomePojo();
		somePojo.setField1("f1");
		somePojo.setField2("f2");
		String serializedPojo = objectMapper.writeValueAsString(somePojo);
		assertEquals("{\"commonField\":\"f1 f2\"}", serializedPojo);
	}

}