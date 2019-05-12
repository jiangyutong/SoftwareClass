package four.kjgz.logistics.mapper;

import four.kjgz.logistics.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
//指定这是一个操作数据库的mapper
//@Mapper//如果不每个类都加上Mapper我们就去主类加上基础报道路径
public interface DepartmentMapper {
    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Delete("delet from department where id=#{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")//是不是使用自动生成的组件 那个属性就是那个主键
    @Insert("insert into department(department_name) values(#{departmentName})")
    public int insertDept(Department department);

    @Update("update department set departmentName=#{departmentName} where id=#{id}")
    public int updataDept(Department department);
}
