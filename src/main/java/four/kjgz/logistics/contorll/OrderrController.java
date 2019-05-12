package four.kjgz.logistics.contorll;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import four.kjgz.logistics.bean.*;
import four.kjgz.logistics.mapper.OrderInfMapper;
import four.kjgz.logistics.mapper.OrderrMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderrController {
    @Autowired
    private OrderrMapper orderrMapper;
    @Autowired
    private OrderInfMapper orderInfMapper;
    Logger logger = LoggerFactory.getLogger(OrderrController.class);
    @Value("${IdWorker.workedId}")
    private Integer workId;

    @Value("${IdWorker.datacenterId}")
    private Integer datacenterId;

    @MyLog(value = "通过编号查找订单")  //这里添加了AOP的自定义注解
    @PostMapping("/selectOrderByNum")
    public Orderr selectOrderByNum(@RequestParam("num") String num){
        Orderr orderr = orderrMapper.findByOrdernum(num);
        if(orderr==null) logger.error("通过编号查找订单失败");
        return orderr;
    }
    @MyLog(value = "通过编号查找订单位置")  //这里添加了AOP的自定义注解
    @PostMapping("/selectOrderLocationByNum")
    public OrderInf selectOrderLocationByNum(@RequestParam("num") String num){

        if(orderInfMapper.findOrderLocationByOrdernum(num).size()==0)
        {
            logger.error("通过编号查找订单位置失败");
            return null;
        }
        else
        {
            List<OrderInf> locations = orderInfMapper.findOrderLocationByOrdernum(num);
            OrderInf location = locations.get(0);
            return location;
        }

    }
    @MyLog(value = "添加订单")  //这里添加了AOP的自定义注解
    @PostMapping("/addOrder")
    public Orderr addOrder(Orderr orderr){
        //生成订单号
        IdWorker idWorker = new IdWorker(workId,datacenterId);
        String ordernum = String.valueOf(idWorker.nextId());

        orderr.setOrdernum(ordernum);
        orderr.setStatus(0);
        System.out.println("ordertime==="+orderr.getSdate());

        int num = orderrMapper.insertOrderr(orderr);
        if (num == 1){
            return orderr;
        }else{
            logger.error("添加订单失败");
            return null;
        }
    }
    @MyLog(value = "通过的id删除订单")  //这里添加了AOP的自定义注解
    @PostMapping("/delOrder")
    public boolean delOrder(@RequestParam("id") Integer id){
        int num = orderrMapper.delOrderr(id);
        if(num==1){
            return true;
        }else{
            logger.error("通过的id删除订单失败");
            return false;
        }
    }
    @MyLog(value = "更新订单")  //这里添加了AOP的自定义注解
    @PostMapping("/updateOrder")
    public boolean updateOrder(Orderr orderr){
        int i = orderrMapper.updateOrderr(orderr);
        System.out.println("返回值是："+i);
        if (i == 1){
            return true;
        }else {
            logger.error("更新订单失败");
            return false;
        }
    }
    @MyLog(value = "通过编号更新订单的位置")  //这里添加了AOP的自定义注解
    @PostMapping("/updateOrderLocationByNum")
    public boolean updateOrderLocationByNum(OrderInf orderInf){
        orderInfMapper.updateOrderLocationByOrdernum(orderInf);
        return true;
    }
    @MyLog(value = "更新订单的状态")  //这里添加了AOP的自定义注解
    @PostMapping("/updateOrderStatus")
    public boolean updateOrderStatus(@RequestParam("id") Integer id,@RequestParam("status") Integer status){
        int i = orderrMapper.updateOrderrStatus(id, status);
        if (i==0){
            return false;
        }else{
            logger.error("更新订单的状态失败");
            return true;
        }
    }
    @MyLog(value = "通过寄件人的id查找订单")  //这里添加了AOP的自定义注解
    @PostMapping("/selectOrdersByCid")
    public List<Orderr> selectOrdersByCid(@RequestParam("cid") Integer cid){
        List<Orderr> orders = orderrMapper.selectOrdersBySid(cid);
        return orders;
    }
    @MyLog(value = "查找所有的订单")  //这里添加了AOP的自定义注解
    @PostMapping("/selectAll")
    public String selectAll(Integer sid) throws JsonProcessingException {
        List<Orderr> orders = orderrMapper.selectOrdersBySid(sid);
        int cont = orderrMapper.getCount();
        Map<String,Object> map = new HashMap<>();
        map.put("orders",orders);
        map.put("count",cont);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(map);
        return s;
    }
    @MyLog(value = "通过快递人员的id查找订单")  //这里添加了AOP的自定义注解
    @PostMapping("/selectOrderBySid")
    public List<OrderInf> selectOrderBySid(@RequestParam("sid") Integer sid){
        List<OrderInf> orderInfList = orderInfMapper.findOrderBySid(sid);
        if (orderInfList != null){
            return orderInfList;
        }else{
            logger.error("通过快递人员的id查找订单失败");
            return null;
        }
    }
}
