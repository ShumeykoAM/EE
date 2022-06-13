package ru.learn.spring.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Пример работы с
 *
 * @since 13.06.2022
 */
@Component
public class ExampleWorkWithResources
{
	@Autowired
	ApplicationContext context;

	public void work()
	{
		try
		{
			File file = File.createTempFile("tmp", "txt");
			file.deleteOnExit();
			try (FileOutputStream outputStream = new FileOutputStream(file))
			{
				outputStream.write("hello".getBytes(StandardCharsets.UTF_8));
			}

			//Произвольный файл
			Resource resource1 = context.getResource("file:" + file.getPath());
			BufferedReader br1 = new BufferedReader(new InputStreamReader(resource1.getInputStream()));
			String s = br1.readLine();

			//Файл из resources
			Resource resource2 = context.getResource("classpath:diff/resfile.txt");
			BufferedReader br2 = new BufferedReader(new InputStreamReader(resource2.getInputStream()));
			s = br2.readLine();

			//WEB ресурс
			/* закоментил что бы не тормозило
			Resource resource3 = context.getResource("http://www.google.com/");
			BufferedReader br3 = new BufferedReader(new InputStreamReader(resource3.getInputStream()));
			s = br3.readLine();*/

			s = null;
		}
		catch (Throwable t)
		{
			t = null;
		}
	}
}
