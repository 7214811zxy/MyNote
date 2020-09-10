package mvc.service;

import mvc.dao.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("serviceImpl")
public class serviceImpl implements service {

    @Resource(name = "daoImpl")
    public dao daoImpl;
    public String getData(int userID) {
        return daoImpl.getUserHobby(userID);
    }
    public void getDataBaseInfo(){
        daoImpl.getDataBaseInfo();
    }

}
