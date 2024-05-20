package net.praysam.demo1.config;

import net.praysam.demo1.mapper.SysRoleMapper;
import net.praysam.demo1.pojo.SysResources;
import net.praysam.demo1.pojo.SysRole;
import net.praysam.demo1.pojo.SysUser;
import net.praysam.demo1.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  认证和授权
 *
 */
public class CustomRealm extends AuthorizingRealm {

    @Autowired private SysUserService userService;
    @Autowired private SysRoleMapper roleMapper;

    /**
     *  第一步，首先需要身份的认证。简单来说就是用户的登录
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken userToken = (UsernamePasswordToken)token;
        String username = userToken.getUsername();
        String password = new String(userToken.getPassword());

        SysUser user = userService.findUserByNameAndPwd(username, password);

        if( null == user ){
            throw new UnknownAccountException();
        }

        return new SimpleAuthenticationInfo(user , password , "");
    }
    /**
     *  第二步，用户判断登录账户是否有权限访问目标资源
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        SysUser user = (SysUser) principals.getPrimaryPrincipal();
        Integer userid = user.getUserid();

        //  注意：这里的版本是一个用户只能有一个角色，实际的使用中，可以出现一个用户拥有多个角色
        SysRole role = roleMapper.get(userid);
        info.addRole( role.getRolename());
        Set<String> set = new HashSet<>();
        List<SysResources> resources = role.getResources();
        for(SysResources r : resources){
            set.add( r.getPermission() );
        }
        info.setStringPermissions(set);
        return info;
    }
}
