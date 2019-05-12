package four.kjgz.logistics.contorll;

import four.kjgz.logistics.bean.MyLog;
import four.kjgz.logistics.bean.Repertory;
import four.kjgz.logistics.mapper.RepertoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepertoryController {
    @Autowired
    private RepertoryMapper repertoryMapper;
    Logger logger = LoggerFactory.getLogger(RepertoryController.class);
    @MyLog(value = "通过id查找仓库")  //这里添加了AOP的自定义注解
    @PostMapping("/selectRepertoryById")
    public Repertory selectRepertoryById(@RequestParam("id") Integer id){
        Repertory repertory = repertoryMapper.selectRepertoryById(id);
        if(repertory==null)
        {
            logger.error("通过id查找仓库失败");
            return  null;
        }
        else
        {
            return repertory;
        }

    }
}
