package mvc.control;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("controlImpl")
public class control {

    //    @Autowired
    //    @Qualifier("serviceImpl")
    @Resource(name = "serviceImpl") // Resource等效于Autowired + Qualifier
    public mvc.service.service service;
    public String request(int userID){
        return service.getData(userID);
    }
    public void getDataBaseInfo(){
        service.getDataBaseInfo();
    }

}
