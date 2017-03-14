package sun.quan.test.spring.boot.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sunquan on 2016/10/21.
 */

@RestController
@RequestMapping("/")
public class TestController {

    @RequestMapping("/show/{id}")
    public String show(@PathVariable("id") String id){
        return id;
    }
}
