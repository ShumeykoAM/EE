package ru.learn.spring.web.filters.order;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.learn.spring.web.filters.SomeFilter;

/**
 * @since 16.05.2022
 */
@Configuration
public class OrderedConfigurationWebFilters
{
	@Bean
	public FilterRegistrationBean<SomeFilter> twoFilter()
	{
		int order = 20;
		FilterRegistrationBean<SomeFilter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new SomeFilter());
		bean.addInitParameter("someParamToSOUT", "Это фильтр номер " + order);
		bean.addUrlPatterns("*");
		bean.setOrder(order);
		return bean;
	}

	@Bean
	public FilterRegistrationBean<SomeFilter> oneFilter()
	{
		int order = 10;
		FilterRegistrationBean<SomeFilter> bean = new FilterRegistrationBean<>();
		bean.setName("oneFilter");
		bean.setFilter(new SomeFilter());
		bean.addInitParameter("someParamToSOUT", "Это фильтр номер " + order);
		bean.addUrlPatterns("*");
		bean.setOrder(order);
		return bean;
	}
}
