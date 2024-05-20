package net.praysam.demo1.config;

import net.praysam.demo1.filter.RolesAuthorizationFilter;
import net.praysam.demo1.filter.SessionFilter;
import net.praysam.demo1.service.SysResourcesService;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 需要3个对象
 * 1. Realm 对象，使用自己定义的对象即可
 * 2. WEB对应的安全管理器：DefaultWebSecurityManager
 * 3. ShiroFilterFacroryBean
 *
 */
@Configuration
public class ShiroConfig {

    @Autowired private SysResourcesService sysResourcesService;
    /**
     *  第一步，创建 CustomRealm 对象，供 SecurityManager对象使用
     * @return
     */
    @Bean
    public net.praysam.demo1.config.CustomRealm getCustomRealm(){
        return new net.praysam.demo1.config.CustomRealm();
    }


    @Bean
    public DefaultWebSecurityManager getSecurityManager(){
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm( getCustomRealm() );
        return dwsm;
    }

    /**
     * 创建过滤器的工厂对象，但是需要知道安全管理的设置，所以需要设置一个安全管理器对象
     *
     * 1. 初始化的时候，为资源进行访问的权限设置
     * 2. 用户访问资源的时候，查找用户的角色和能够访问的资源权限
     * 3. 对比2次的权限和角色
     *
     * @param defaultWebSecurityManager
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFacroryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager);

        // 如果没有设置，访问项目根路径下的login页面
        factoryBean.setLoginUrl("/index.html");
        //  登录成功后跳转的连接
        factoryBean.setSuccessUrl("/home");
        //  发生错误的时候，跳转的请求路径
        factoryBean.setUnauthorizedUrl("/error");


        /**
         * LinkedHashMap 之所以使用这个类型，是因为shiro是按照先后顺序就行排查，如果在第一次就发现符合要求，就会跳出
         */


        Map<String,String> filterChainDefinitionMap = sysResourcesService.findAllResources();

        /**
         * 设置过滤器，常用的几个过滤器如下：
         *
         *  anon: 不需要认证 
         *  authc: 需要认证
         *  user:  记住我
         *  roles: 基于角色访问
         *  perms: 基于权限访问
         *
         *  Map 的key是请求的路径，需要以斜杠开头
         *  Value是对相应的控制器
         */
        filterChainDefinitionMap.put("/logout" , "logout");
        filterChainDefinitionMap.put("/data**" , "authc");
        filterChainDefinitionMap.put("/**" , "anon");
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        //  覆盖shiro 的过滤器
        Map<String, Filter> myFilter = new LinkedHashMap<>();
        myFilter.put("roles" , new RolesAuthorizationFilter());
        myFilter.put("authc" , new SessionFilter());
        factoryBean.setFilters(myFilter);
        return factoryBean;
    }

}
