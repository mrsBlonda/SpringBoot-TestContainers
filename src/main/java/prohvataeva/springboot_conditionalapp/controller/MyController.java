package prohvataeva.springboot_conditionalapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import prohvataeva.springboot_conditionalapp.module.SystemProfile;

@RestController
@RequestMapping("/")
public class MyController {

    private SystemProfile profile;

    public MyController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("profile")
    public String getProfile() {
        return profile.getProfile();
    }
}
