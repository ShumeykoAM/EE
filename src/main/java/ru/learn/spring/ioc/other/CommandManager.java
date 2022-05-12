package ru.learn.spring.ioc.other;

/**
 * @since 07.05.2022
 */
public abstract class CommandManager
{
	public void process()
	{
		createCommand().doExecute();
	}

	protected abstract Command createCommand();

	public static class Command
	{
		private static Integer counter = 0;

		public Command()
		{
			counter++;
		}

		public void doExecute()
		{
			System.out.println(counter);
		}
	}
}
