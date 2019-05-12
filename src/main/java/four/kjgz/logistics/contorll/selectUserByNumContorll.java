package four.kjgz.logistics.contorll;

import four.kjgz.logistics.bean.MyLog;
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
public class selectUserByNumContorll {
    @Autowired
    AdministratorsReposity administratorsReposity;
    @Autowired
    CustomerReposity customerReposity;
    @Autowired
    StaffReposity staffReposity;
    Logger logger = LoggerFactory.getLogger(selectUserByNumContorll.class);
    @MyLog(value = "通过的num查找用户")  //这里添加了AOP的自定义注解
    @PostMapping(value = "/selectUserByNum")
    @CrossOrigin(origins = "http://localhost:8080")    //注解用于存储数据时的跨域问题
    public Object  selectUserByNum(@RequestParam("num") String num)
    {
        char first = num.charAt(0);
        if (first=='1')//表示为管理员
        {
            if(administratorsReposity.findByAdministratorsNum(num).size()==0)
            {
                logger.error("没有该用户");
                return "更新失败";
            }
            else
                return  administratorsReposity.findByAdministratorsNum(num);

        }
        else if(first=='2')//表示工作人员
        {
            if(staffReposity.findByStaffNum(num).size()==0)
            {
                logger.error("没有该用户");
                return "更新失败";
            }
            else
                return  staffReposity.findByStaffNum(num);

        }
        else{
            if(customerReposity.findByCustomerNum(num).size()==0)
            {
                logger.error("没有该用户");
                return "更新失败";
            }
            else
            return  customerReposity.findByCustomerNum(num);
        }
    }
}
