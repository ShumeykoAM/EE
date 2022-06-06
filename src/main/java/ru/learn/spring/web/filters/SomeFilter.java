package ru.learn.spring.web.filters;

import java.io.IOException;
import javax.servlet.*;

/**
 * @since 16.05.2022
 */
public class SomeFilter implements Filter
{
	private String someParamToSOUT;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		someParamToSOUT = filterConfig.getInitParameter("someParamToSOUT");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		System.out.println(someParamToSOUT);
		chain.doFilter(request, response);
	}
}
