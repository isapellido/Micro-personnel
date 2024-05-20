package net.praysam.demo1.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Set;


/**
 * 这个过滤器是覆盖shiro默认的过滤器的，用于判断角色，只要有一个符合的就返回true
 */
public class RolesAuthorizationFilter extends AuthorizationFilter {

    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            return true;
        }

        Set<String> roles = CollectionUtils.asSet(rolesArray);

        for(String role : roles){
            if( subject.hasRole(role)){
                return true;
            }
        }

        return false;
    }

}
