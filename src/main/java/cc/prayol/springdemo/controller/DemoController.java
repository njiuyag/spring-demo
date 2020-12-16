package cc.prayol.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjx
 * @date 2020/12/16
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        return "abb";
    }
}
