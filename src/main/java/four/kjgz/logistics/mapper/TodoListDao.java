package four.kjgz.logistics.mapper;

import four.kjgz.logistics.bean.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.repository.query.Param;

@Mapper
public interface TodoListDao {

    @Select("select * from department where id=#{id}")
    public Department getDeptById(Integer id);

    @Update({"create table "+"${tableName}"+"( "+"${myone}"+" int PRIMARY KEY NOT NULL AUTO_INCREMENT," +
            " title varchar(20) NOT NULL," +
            " detail varchar(200) DEFAULT NULL," +
            " status int(1) DEFAULT 0," +
            " priority int(1) DEFAULT 0," +
            " exceptfinishdate date DEFAULT NULL," +
            " createddate date DEFAULT NULL)" +
            " ENGINE=InnoDB DEFAULT CHARSET=utf8"})
    public void createTodolist(@Param("tableName") String tableName, @Param("myone") String myone);

    @Update({"drop table if exists "+"${_parameter}"})
    public void dropExistTable(@Param("tableName") String tableName);


}
