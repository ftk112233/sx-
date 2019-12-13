package com.mt.sx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

/**
 * controller通用方法
 * @author g
 * @date 2019-11-16 13:32
 */
@Controller
public class BaseController {

    /**
     * 获取项目类路径
     * @throws FileNotFoundException
     */
    public static String getClasspath() throws FileNotFoundException {
        return ResourceUtils.getURL("classpath:").getPath();
    }
}
