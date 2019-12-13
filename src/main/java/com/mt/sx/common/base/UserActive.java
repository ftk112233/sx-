package com.mt.sx.common.base;

import com.mt.sx.pojo.SxBusiness;
import lombok.Data;

import javax.management.relation.Role;
import java.security.Permission;
import java.util.List;

@Data
public class UserActive {
   private SxBusiness business;
   private List<Role> roles;
   private List<Permission> permissions;
}
