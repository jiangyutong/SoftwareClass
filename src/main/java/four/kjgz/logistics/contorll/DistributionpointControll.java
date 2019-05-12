package four.kjgz.logistics.contorll;

import four.kjgz.logistics.bean.*;
import four.kjgz.logistics.repository.DistributionpointReposity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistributionpointControll {
    Logger logger = LoggerFactory.getLogger(Distributionpoint.class);
    @Autowired
    loginInfo nowloginInfo;
    @Autowired
    DistributionpointReposity distributionpointReposity;

    @MyLog(value = "通过名字查找配送点")  //这里添加了AOP的自定义注解
    @PostMapping(value = "/selectDpByName")
    public Object selectDpByName(@RequestParam("name") String name)
    {
        if(distributionpointReposity.findByName(name).size()==0)
        {
            logger.error("通过名字查找配送点失败");
            return "通过名字查找配送点失败";
        }
        else return  distributionpointReposity.findByName(name);
    }
    //插入的第一种方法
    @MyLog(value = "插入配送点")  //这里添加了AOP的自定义注解
    @PostMapping(value = "/addDp")
    public Object addDp(
            @RequestParam("name") String name,
            @RequestParam("location") String location
    )
    {
       // System.out.println("现在登陆的账号是"+nowloginInfo.getMyusernum());
       // Mycheck mycheck = new Mycheck();
        // if(nowloginInfo.getResult()!="成功")
        // {
         //   return nowloginInfo.getResult();
        // }
      //  else
         //{
             Distributionpoint distributionpoint= new Distributionpoint();
             distributionpoint.setLocation(location);
             distributionpoint.setName(name);
             if(distributionpointReposity.save(distributionpoint)==null)
             {
                 logger.error("插入配送点失败");
                 return "插入配送点失败";
             }
             else
             return  distributionpointReposity.save(distributionpoint);
       //  }

    }
    @MyLog(value = "通过位置查找配送点")  //这里添加了AOP的自定义注解
    @PostMapping(value = "/selectDpByLocation")
    public Object selectDpByLocation(
            @RequestParam("location") String location
    )
    {
        if(distributionpointReposity.findByLocation(location).size()==0)
        {
            logger.error("查找失败，没有该配送点");
            return  "查找失败，没有该配送点";
        }
        else
        {
            return distributionpointReposity.findByLocation(location);
        }

    }
    @MyLog(value = "删除配送点")  //这里添加了AOP的自定义注解
    @PostMapping(value = "/delDp")
    public Object delDp(
            @RequestParam("name") String name,
            @RequestParam("location") String location
    )
    {
        if(distributionpointReposity.findByNameAndLocation(name,location).size()==0)
        {
            logger.error("删除失败，没有该配送点");
            return  "删除失败，没有该配送点";
        }
        else
        {
            return distributionpointReposity.deleteByNameAndLocation(name,location);
        }

    }
}
