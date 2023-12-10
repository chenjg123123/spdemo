package spring.review.demo.sys.entity;

import java.util.ArrayList;
import java.util.List;

public class SocietyDTO {
    private Society society;
    private User user;
//    private List<Society> societyList = new ArrayList<>();
    public void setSociety(Society society) {
        this.society = society;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
