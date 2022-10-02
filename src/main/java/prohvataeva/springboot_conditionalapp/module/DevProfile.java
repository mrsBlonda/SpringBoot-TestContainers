package prohvataeva.springboot_conditionalapp.module;

public class DevProfile implements SystemProfile {

    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
