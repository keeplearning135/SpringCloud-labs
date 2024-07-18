package org.itstack.eurekazuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.HttpServletRequest;


public class TokenFilter extends ZuulFilter {


    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }


    public int filterOrder() {
        return 0;
    }


    public boolean shouldFilter() {
        return true;
    }


    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String token = request.getParameter("token");
        if (token == null || token.isEmpty()) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("refuse! token is empty");
        }
        return null;
    }

}
