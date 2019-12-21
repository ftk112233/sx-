package com.mt.sx.controller;

import com.mt.sx.service.SxPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.beans.Transient;

@RestController
@RequestMapping("/permission")
public class SxPermissionController {
    @Autowired
    SxPermissionService sxPermissionService;
}
