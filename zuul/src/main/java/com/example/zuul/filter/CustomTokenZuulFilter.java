package com.example.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义Token ZullFilter
 */
public class CustomTokenZuulFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String filterType() {
        return "pre";// 可以在请求被路由之前调用
    }

    @Override
    public int filterOrder() {
        return 0;// filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
    }

    @Override
    public boolean shouldFilter() {
        return true;// 是否执行该过滤器，此处为true，说明需要过滤
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info("--->>>>> TokenZuulFilter {},{}", request.getMethod(), request.getRequestURL().toString());

        String token = request.getParameter("token");
        if (StringUtils.isNotEmpty(token)) {
            currentContext.setSendZuulResponse(true);
            currentContext.setResponseStatusCode(200);
            currentContext.set("isSuccess", true);
        } else {
            currentContext.setSendZuulResponse(false);//zuul不对其进行路由
            currentContext.setResponseStatusCode(400);
            currentContext.setResponseBody("token is empty");
            currentContext.set("isSuccess", false);
        }
        return null;
    }
}
