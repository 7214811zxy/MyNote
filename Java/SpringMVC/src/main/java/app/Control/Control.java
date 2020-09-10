package app.Control;

import app.Service.ServiceInterface;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("control")
public class Control {

    @Resource(name="serviceImpl")
    ServiceInterface service;

    // 一笔转账交易
    // deal(付款人，收款人，金额)
    public void deal( String payMan, String receiveMan, int money ){
        service.transfer(payMan, receiveMan, money);
    }

}
