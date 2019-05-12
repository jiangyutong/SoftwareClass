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

import java.util.Random;

@RestController
public class registerContorll {
    Logger logger = LoggerFactory.getLogger(registerContorll.class);
    @Autowired
    AdministratorsReposity administratorsReposity;
    @Autowired
    CustomerReposity customerReposity;
    @Autowired
    StaffReposity staffReposity;
    @MyLog(value = "添加用户")  //这里添加了AOP的自定义注解
    @PostMapping(value = "/register")
    @CrossOrigin(origins = "http://localhost:8080")    //注解用于存储数据时的跨域问题
    public  Object register(@RequestParam("action") Integer action,
                            @RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("email") String email,
                            @RequestParam("sex") String sex,
                            @RequestParam("address") String address
                            )
    {
        Random random = new Random();
        Integer numberone=random.nextInt(5) + 1;
        String image="http://47.100.164.146:8080/girl-0.0.1-SNAPSHOT/img/"+"tx"+numberone+".png";

        if(action==1)//插入管理员
        {
            String administratorsCountString=null;
            if(administratorsReposity.findMaxNum()==null)
            {
                Integer administratorsCount=administratorsReposity.administratorsCount()+1+100000000;
                System.out.println(administratorsReposity.administratorsCount());
                 administratorsCountString=String.valueOf(administratorsCount);
            }
            else
            {
                int i=Integer.parseInt(administratorsReposity.findMaxNum())+1;
                 administratorsCountString=String.valueOf(i);
            }

            Administrators administrators =new Administrators();
            administrators.setImage(image);
            administrators.setAdministratorsNum(administratorsCountString);
            administrators.setEmail(email);
            administrators.setPassword(password);
            administrators.setSex(sex);
            administrators.setUsername(username);
            if(administratorsReposity.save(administrators)==null)
            {
                logger.error("注册失败");
                return "注册失败";
            }
            else
                return  administratorsReposity.save(administrators);


        }
        else if(action==2)//插入工作人员
        {
            String staffCountString=null;
            if(staffReposity.findMaxNum()==null)
            {
                Integer staffCount=staffReposity.staffCount()+1+200000000;
                System.out.println(staffReposity.staffCount());
                staffCountString=String.valueOf(staffCount);
            }
            else
            {
                int i=Integer.parseInt(staffReposity.findMaxNum())+1;
                staffCountString=String.valueOf(i);
            }


            Staff staff=new Staff();
            staff.setStaffNum(staffCountString);
            staff.setEmail(email);
            staff.setImage(image);
            staff.setPassword(password);
            staff.setSex(sex);
            staff.setUsername(username);
            if(staffReposity.save(staff)==null)
            {
                logger.error("注册失败");
                return "注册失败";
            }
            else
                return  staffReposity.save(staff);

        }
        else //插入顾客
        {

            String customerCountString=null;
            if(administratorsReposity.findMaxNum()==null)
            {
                Integer customerCount=customerReposity.customerCount()+1+300000000;
                System.out.println(customerReposity.customerCount());

            }
            else
            {
                int i=Integer.parseInt(customerReposity.findMaxNum())+1;
                customerCountString=String.valueOf(i);
            }


            Customer customer=new Customer();
            customer.setCustomerNum(customerCountString);
            customer.setAddress(address);
            customer.setEmail(email);
            customer.setImage(image);
            customer.setPassword(password);
            customer.setUsername(username);
            customer.setSex(sex);
            if(customerReposity.save(customer)==null)
            {
                logger.error("注册失败");
                return "注册失败";
            }
            else
                return  customerReposity.save(customer);
        }
    }
}
