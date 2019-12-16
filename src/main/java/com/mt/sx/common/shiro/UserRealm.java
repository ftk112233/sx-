package com.mt.sx.common.shiro;


import com.mt.sx.common.base.UserActive;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.pojo.SxPermission;
import com.mt.sx.pojo.SxRole;
import com.mt.sx.service.SxBusinessService;
import com.mt.sx.service.SxPermissionService;
import com.mt.sx.service.SxRoleService;
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
import java.util.List;


public class UserRealm extends AuthorizingRealm {

	@Autowired
	@Lazy  //只有使用的时候才会加载 
	private SxBusinessService sxBusinessService;
	
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

		String username=(String)token.getPrincipal();
		SxBusiness business = sxBusinessService.findByName(username);
		if (null != business) {
			UserActive userActive=new UserActive();
			userActive.setBusiness(business);
			//获取拥有的角色
			List<SxRole> roles = sxRoleService.allRolesByBid(business.getId());
			//角色名集合
			List<String> roleNames=new ArrayList<>();
			//权限名集合
			List<String> permissionName=new ArrayList<>();
			for (SxRole role:roles){
				roleNames.add(role.getName());
				//查询角色拥有的所有权限
				List<SxPermission> sxPermissions = sxPermissionService.allPermissionsByRid(role.getId());

				for (SxPermission permission :sxPermissions){
					permissionName.add(permission.getPercode());
				}
			}
			userActive.setRoles(roleNames);
			userActive.setPermissions(permissionName);
			//获取盐
			String solt=business.getSolt();
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(userActive, business.getPassword(), ByteSource.Util.bytes(solt),
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
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		UserActive userActive=(UserActive) principals.getPrimaryPrincipal();
		SxBusiness business=userActive.getBusiness();
		List<String> roles=userActive.getRoles();
		List<String> permissions = userActive.getPermissions();

		if(roles.contains("超级管理员")) {
			authorizationInfo.addStringPermission("*:*");
		}else {
			if(null!=permissions&&permissions.size()>0) {
				authorizationInfo.addStringPermissions(permissions);
			}
		}
		return authorizationInfo;
	}

}
