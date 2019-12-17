package com.mt.sx.common.base;

import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.pojo.SxUser;
import lombok.Data;

import javax.management.relation.Role;
import java.io.Serializable;
import java.security.Permission;
import java.util.List;

@Data
public class UserActive implements Serializable {
   private SxUser user;
   private List<String> roles;
   private List<String> permissions;
}
