package cn.qianshu.pingfen.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

@Component  
@ServletComponentScan  
@WebFilter(filterName="vFilterSecurityInterceptor",urlPatterns="/*")  
public class VFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {  
  
    @Autowired  
    private VFilterInvocationSecurityMetadataSource vFilterInvocationSecurityMetadataSource;  
  
    @Autowired  
    public void setMyAccessDecisionManager(VAccessDecisionManager vAccessDecisionManager) {  
        super.setAccessDecisionManager(vAccessDecisionManager);  
    }  
  
    @Override  
    public void init(FilterConfig filterConfig) throws ServletException {  
    }  
  
    @Override  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)  
            throws IOException, ServletException {  
        FilterInvocation filterInvocation = new FilterInvocation(request, response, chain);  
        invoke(filterInvocation);  
    }  
  
    public void invoke(FilterInvocation filterInvocation) throws IOException, ServletException {  
        // filterInvocation里面有一个被拦截的url  
        // 里面调用VFilterInvocationSecurityMetadataSource的getAttributes(Object object)这个方法获取filterInvocation对应的所有权限  
        // 再调用VAccessDecisionManager的decide方法来校验用户的权限是否足够  
        InterceptorStatusToken interceptorStatusToken = super.beforeInvocation(filterInvocation);  
        try {  
            // 执行下一个拦截器  
            filterInvocation.getChain().doFilter(filterInvocation.getRequest(), filterInvocation.getResponse());  
        } finally {  
            super.afterInvocation(interceptorStatusToken, null);  
        }  
    }  
  
    @Override  
    public void destroy() {  
    }  
  
    @Override  
    public Class<?> getSecureObjectClass() {  
        return FilterInvocation.class;  
    }  
  
    @Override  
    public SecurityMetadataSource obtainSecurityMetadataSource() {  
        return this.vFilterInvocationSecurityMetadataSource;  
    }  
  
}
