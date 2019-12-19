package com.mt.sx.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mt.sx.pojo.SxBusiness;
import com.mt.sx.pojo.SxUser;


import java.io.UnsupportedEncodingException;
import java.util.Date;


public class JwtUtils {
    public static String createToken(SxUser sxUser) throws UnsupportedEncodingException {
        String token = "";
        token = JWT.create().withAudience(sxUser.getId().toString(),new Date().toString()).sign(Algorithm.HMAC256(sxUser.getPassword()));
        return token;
    }
    public static Integer deCode(String token){
      return Integer.parseInt(JWT.decode(token).getAudience().get(0));
    }

}
