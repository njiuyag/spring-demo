package cc.prayol.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hjx
 * @date 2020/12/16
 */
@RestController
@RequestMapping(value = "/heartbeat")
public class HeartbeatController {

    @RequestMapping(method = RequestMethod.GET)
    public Long heartbeat(){
        return System.currentTimeMillis();
    }
}
