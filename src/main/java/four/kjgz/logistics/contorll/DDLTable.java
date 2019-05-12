package four.kjgz.logistics.contorll;

import four.kjgz.logistics.mapper.TodoListDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DDLTable {
    @Autowired
    TodoListDao todoListDao;
    @GetMapping(value = "/create")
    public  void  create(@Param("tableName")  String tableName,
                         @Param("myone")  String myone
    )
    {
        System.out.println("jyt");
        todoListDao.createTodolist(tableName,myone);
    }
    @GetMapping(value = "/drop")
    public  void  drop(@Param("tableName") String tableName)
    {
        System.out.println("jyt");
        todoListDao.dropExistTable(tableName);
    }
}
