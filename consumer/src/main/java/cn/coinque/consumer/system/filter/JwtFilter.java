package cn.coinque.consumer.system.filter;


import cn.coinque.consumer.system.exception.NotAuthorizedException;
import cn.coinque.consumer.system.utils.Audience;
import cn.coinque.consumer.system.utils.Constants;
import cn.coinque.consumer.system.utils.JwtHelper;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;
/**
 * Created by gaowh on 2019/11/27.
 */
public class JwtFilter extends GenericFilterBean {

    @Autowired
    private Audience audience;

    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"/user/login","/v3/swagger-login","/swagger-resources","/favicon.ico","/swagger-resources/*", "/swagger-ui.html/*","/v2/api-docs","/static/css/app.d3c28ed4bb0b3527dc5d8390a59e1c31.css","/static/js/manifest.37a2ecbb1d1b7e6c9ada.js","/static/js/vendor.3fddc87998db19b981e4.js","/static/js/app.9f3f4042f1e02d4cd1ca.js","/static/js/app.9f3f4042f1e02d4cd1ca.js"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        //等到请求头信息authorization信息
        final String authHeader = request.getHeader("authorization");
        //是否需要过滤
        String uri = request.getRequestURI();
        boolean needFilter = isNeedFilter(uri);
        if (!needFilter) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            if (authHeader == null || !authHeader.startsWith("bearer;")) {
                throw new NotAuthorizedException();
            }
            final String token = authHeader.substring(7);

            try {
                if(audience == null){
                    BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
                    audience = (Audience) factory.getBean("audience");
                }
                final Claims claims = JwtHelper.parseJWT(token,audience.getBase64Secret());
                if(claims == null){
                    throw new NotAuthorizedException();
                }
                request.setAttribute(Constants.CLAIMS, claims);
            } catch (final Exception e) {
                throw new NotAuthorizedException();
            }

            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if(Pattern.matches(includeUrl,uri)) {
                return false;
            }
        }
        return true;
    }
}
