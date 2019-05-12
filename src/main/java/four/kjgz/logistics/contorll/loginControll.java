package four.kjgz.logistics.contorll;

import four.kjgz.logistics.bean.*;
import four.kjgz.logistics.repository.AdministratorsReposity;
import four.kjgz.logistics.repository.CustomerReposity;
import four.kjgz.logistics.repository.StaffReposity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginControll {
    @Autowired
    loginInfo nowloginInfo;
    @Autowired
    AdministratorsReposity administratorsReposity;
    @Autowired
    CustomerReposity customerReposity;
    @Autowired
    StaffReposity staffReposity;
    Logger logger = LoggerFactory.getLogger(loginControll.class);
    @MyLog(value = "用户登录")  //这里添加了AOP的自定义注解
    @PostMapping(value = "/login")

    public Object login(@RequestParam("num") String num,
                        @RequestParam("password") String password)
    {
        nowloginInfo.setMyusernum(num);
        char first = num.charAt(0);
        if (first=='1')//表示为管理员
        {
            if(administratorsReposity.findByAdministratorsNum(num).size()==0)
            {
                logger.error("用户名错误");
                return "用户名错误";
            }
            else
            {
                if(administratorsReposity.findByAdministratorsNumAndPassword(num,password).size()==0)
                {
                    logger.error("密码错误");
                    return "密码错误";
                }
                else
                {
                    Administrators administrators=administratorsReposity.findByAdministratorsNumAndPassword(num,password).get(0);
                    nowloginInfo.setMyusername(administrators.getUsername());
                    return  administratorsReposity.findByAdministratorsNumAndPassword(num,password);
                }
            }

        }
        else if(first=='2')//表示工作人员
        {
            if(staffReposity.findByStaffNum(num).size()==0)
            {
                logger.error("用户名错误");
                return "用户名错误";
            }
            else
            {
                if(staffReposity.findByStaffNumAndPassword(num,password).size()==0)
                {
                    logger.error("密码错误");
                    return "密码错误";
                }
                else
                {
                    Staff staff=staffReposity.findByStaffNumAndPassword(num,password).get(0);
                    nowloginInfo.setMyusername(staff.getUsername());
                    return  staffReposity.findByStaffNumAndPassword(num,password);
                }
            }

        }
        else{
            if(customerReposity.findByCustomerNum(num).size()==0)
            {
                logger.error("用户名错误");
                return "用户名错误";
            }
            else
            {
                if(customerReposity.findByCustomerNumAndPassword(num,password).size()==0)
                {
                    logger.error("密码错误");
                    return "密码错误";
                }
                else
                {
                    Customer customer=customerReposity.findByCustomerNumAndPassword(num,password).get(0);
                    nowloginInfo.setMyusername(customer.getUsername());
                    return  customerReposity.findByCustomerNumAndPassword(num,password);
                }
            }

        }
        }
}
