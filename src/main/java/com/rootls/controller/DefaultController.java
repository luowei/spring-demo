package com.rootls.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by luowei on 2014/4/25.
 */
@Controller
@RequestMapping
public class DefaultController {

//    private static final Logger logger = Logger.getLogger(DefaultController.class.getName());
    private static final Logger logger = Logger.getLogger(DefaultController.class);

    @RequestMapping("/")
    public String index(){
        logger.debug("default index !!");
        return "index";
    }

}
