package com.rootls.controller

import groovy.util.logging.Log4j
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
 * Created by luowei on 2014/4/25.
 */
@Controller
@RequestMapping("/home")
@Log4j
class HomeController {

    @RequestMapping
    def index(){
        log.debug " home index !!!"
//        log.debug ("--------------rootls.com------------")
        "home/index";
    }

}
