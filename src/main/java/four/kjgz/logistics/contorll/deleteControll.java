package four.kjgz.logistics.contorll;

import four.kjgz.logistics.bean.Administrators;
import four.kjgz.logistics.bean.Customer;
import four.kjgz.logistics.bean.MyLog;
import four.kjgz.logistics.bean.Staff;
import four.kjgz.logistics.repository.AdministratorsReposity;
import four.kjgz.logistics.repository.CustomerReposity;
import four.kjgz.logistics.repository.StaffReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class deleteControll {
    @Autowired
    AdministratorsReposity administratorsReposity;
    @Autowired
    CustomerReposity customerReposity;
    @Autowired
    StaffReposity staffReposity;
    @MyLog(value = "删除用户")  //这里添加了AOP的自定义注解
    @PostMapping(value = "/delUser")
    public  Object delUser(@RequestParam("num") String num) {
        char first = num.charAt(0);
        if (first=='1')//表示为管理员
        {
            return administratorsReposity.deleteByAdministratorsNum(num);
        }
        else if(first=='2')//表示工作人员
        {
            return  staffReposity.deleteByStaffNum(num);
        }
        else{
            return  customerReposity.deleteByCustomerNum(num);
        }
    }
}
