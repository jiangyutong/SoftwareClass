package four.kjgz.logistics.contorll;

import four.kjgz.logistics.repository.EmployeeReposity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeControll {
    @Autowired
    EmployeeReposity employeeReposity;

    @GetMapping(value = "/updateTable")
    @CrossOrigin(origins = "http://localhost:8080")    //注解用于存储数据时的跨域问题
    public int updateTable(@Param("status")  String status,
                           @Param("id")  String id)
    {
        return  employeeReposity.updateStatusById(status,id);
    }
}
