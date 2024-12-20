package spring.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {
    private final DataService dataService;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/user")
    public String user(){
        return dataService.getUser();
    }
    @GetMapping("/owner")
    public Account owner(String name){
        return dataService.getOwner(name);
    }
    @GetMapping("/display")
    public String display(){
        return dataService.display();
    }
    @GetMapping("/authentication")
    public Authentication authentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }
}