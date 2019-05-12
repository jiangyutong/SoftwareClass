package four.kjgz.logistics.mapper;


import four.kjgz.logistics.bean.Repertory;
import org.apache.ibatis.annotations.Select;

public interface RepertoryMapper {
    @Select("select * from Repertory where id = #{id}")
    public Repertory selectRepertoryById(Integer id);
}
