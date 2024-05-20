package net.praysam.demo1.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.praysam.demo1.util.ResultBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


/**
 * 在认证过滤器的原有代码中，添加ajax的判断
 */
public class SessionFilter extends FormAuthenticationFilter {

    private final static String X_REQUEST_WITH = "X-Requested-With";
    private final static String XML_HTTP_REQUEST = "XMLHttpRequest";
    private final static String SESSION_OUT = "SESSION_OUT";

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        if (isLoginRequest(request, response)) {

            if (isLoginSubmission(request, response)) {
                return executeLogin(request, response);
            } else {
                return true;
            }
        } else {

            if (isAjax((HttpServletRequest) request)) {
                String jsonData = new ObjectMapper().writeValueAsString(ResultBean.error(500, SESSION_OUT));
                response.getWriter().print(jsonData);
                response.getWriter().flush();
                response.getWriter().close();
            } else {
                saveRequestAndRedirectToLogin(request, response);
            }
            return false;
        }
    }

    private boolean isAjax(HttpServletRequest request) {
        String header = request.getHeader(X_REQUEST_WITH);
        if (XML_HTTP_REQUEST.equalsIgnoreCase(header)) {
            return true;
        }
        return false;
    }


}
