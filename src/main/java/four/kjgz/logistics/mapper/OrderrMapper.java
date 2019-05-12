package four.kjgz.logistics.mapper;

import four.kjgz.logistics.bean.Orderr;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OrderrMapper {
    @Select("select * from Orderr where ordernum = #{num}")
    public Orderr findByOrdernum(String num);

    @Options(useGeneratedKeys = true,keyProperty = "id")//是不是使用自动生成的组件 那个属性就是那个主键
    @Insert("insert into Orderr(cid,sname,sphone,saddress,sdate,rname,rphone,raddress,goodstype,paytype,ordernum,status) values(#{cid},#{sname},#{sphone},#{saddress},#{sdate},#{rname},#{rphone},#{raddress},#{goodstype},#{paytype},#{ordernum},0)")
    public int insertOrderr(Orderr orderr);

    @Delete("delete from Orderr where id=#{id}")
    public int delOrderr(Integer id);

    @Update("update Orderr set sname = #{sname},sphone = #{sphone},saddress = #{saddress},sdate = #{sdate},rname = #{rname},rphone = #{rphone},raddress = #{raddress} where id = #{id}")
    public int updateOrderr(Orderr orderr);

    @Update("update Orderr set status = #{status} where id = #{id}")
    public int updateOrderrStatus(Integer id, Integer status);

    @Select("select * from Orderr where cid = #{cid}")
    public List<Orderr> selectOrdersBySid(Integer cid);

    @Select("select count(id) from Orderr")
    public int getCount();
}
