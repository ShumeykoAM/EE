package learn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/servlet/annotatedSimpleServlet")
public class SimpleServlet extends HttpServlet
{
	private String message;
	private static final Cookie[] COOKIES_EMPTY_ARRAY = new Cookie[0];

	@Override
	public void init() throws ServletException
	{
		message = "first";
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session =request.getSession(true);
		Integer sessionCounter = Optional.ofNullable((Integer)session.getAttribute("SessionCounter")).orElse(1);

		int count = 1;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : (cookies != null ? cookies : COOKIES_EMPTY_ARRAY))
			if ("counter".equals(cookie.getName()))
				count = Integer.valueOf(cookie.getValue()) + 1;

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>" + String.format("Hello, according to the cookies, it is your %s visit.", count) + "</h1></br>");
		out.println("<h1>" + String.format("Session counter %d.", sessionCounter) + "</h1>");

		session.setAttribute("SessionCounter", ++sessionCounter);

		//Создаем куку
		Cookie cookie = new Cookie("counter", Integer.toString(count));
		//Максимальное время жизни куки
		cookie.setMaxAge(5);

		//Добавляем куку в ответ, браузер сохранит ее у себя
		response.addCookie(cookie);
	}

	@Override
	public void destroy()
	{
		message = null;
	}
}
