package com.mt.sx.common.shiro;


import com.mt.sx.common.base.UserActive;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.pojo.SxPermission;
import com.mt.sx.pojo.SxRole;
import com.mt.sx.pojo.SxUser;
import com.mt.sx.service.SxBusinessService;
import com.mt.sx.service.SxPermissionService;
import com.mt.sx.service.SxRoleService;
import com.mt.sx.service.SxUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    @Lazy  //只有使用的时候才会加载
    private SxUserService sxUserService;

    @Autowired
    @Lazy
    private SxPermissionService sxPermissionService;

    @Autowired
    @Lazy
    private SxRoleService sxRoleService;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        SxUser user = sxUserService.findByName(username);
        if (null != user) {
            UserActive userActive = new UserActive();
            userActive.setUser(user);
            //获取拥有的角色
            List<SxRole> roles = sxRoleService.allRolesByBid(user.getId());
            //角色名集合
            Set<String> roleNames = new HashSet<>();
            //权限名集合
            Set<String> permissionName = new HashSet<>();
            for (SxRole role : roles) {
                roleNames.add(role.getName());
                //查询角色拥有的所有权限
                List<SxPermission> sxPermissions = sxPermissionService.allPermissionsByRid(role.getId());

                for (SxPermission permission : sxPermissions) {
                    permissionName.add(permission.getPercode());
                }
            }
            userActive.setRoles(roleNames);
            userActive.setPermissions(permissionName);
            //获取盐
            String salt = user.getSalt();
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userActive, user.getPassword(), ByteSource.Util.bytes(salt),
                    this.getName());
            return info;
        }
        return null;
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserActive userActive = (UserActive) principals.getPrimaryPrincipal();
        Set<String> roles = userActive.getRoles();
        Set<String> permissions = userActive.getPermissions();
        if (null != roles && roles.size() > 0) {
            authorizationInfo.setRoles(roles);
        }
        if(roles.contains("admin")) {
            authorizationInfo.addStringPermission("*:*");
        }else {
            if (null != permissions && permissions.size() > 0) {
                authorizationInfo.setRoles(permissions);
            }
        }


        return authorizationInfo;
    }

}
