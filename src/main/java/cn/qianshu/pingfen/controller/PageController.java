package cn.qianshu.pingfen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
public class PageController {  
      
    @RequestMapping("/admin")
    //@PreAuthorize("hasAuthority('R_ADMIN')")
    public String admin(Model model, String tt) {  
        return "admin";  
    }  
      
    @RequestMapping("/hello")  
    public String hello(Model model, String tt) {  
        return "hello";  
    }  
}