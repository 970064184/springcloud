package com.example.cloud;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * zuul 过滤器之一PRE
 */
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class PreZuulFilter extends ZuulFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(PreZuulFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;// true的时候才会执行这个过滤器
	}

	@Override
	public Object run() {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		String remoteHost = request.getRemoteHost();
		LOGGER.info("请求的host:{}", remoteHost);
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 数字越大越靠后
	 * 
	 * @return
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 5;
	}

}
