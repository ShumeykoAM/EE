package ru.learn.spring.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

/**
 * @since 23.10.2021
 */
@JsonComponent
public class SomePojoSerializer extends JsonSerializer<SomePojo>
{
	@Override
	public void serialize(SomePojo value, JsonGenerator gen, SerializerProvider serializers) throws IOException
	{
		gen.writeStartObject();
		gen.writeStringField("commonField", value.getField1() + " " + value.getField2());
		gen.writeEndObject();
	}
}
