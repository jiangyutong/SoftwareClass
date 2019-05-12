package four.kjgz.logistics.mapper;

import four.kjgz.logistics.bean.OrderInf;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderInfMapper {
    @Select("select * from OrderInf where ordernum = #{num} order by id DESC")
    public List<OrderInf> findOrderLocationByOrdernum(String num);

    @Insert("insert into OrderInf(ordernum,nowlocation,nextlocation,sid) values(#{ordernum},#{nowlocation},#{nextlocation},#{sid})")
    public Integer updateOrderLocationByOrdernum(OrderInf orderInf);

    @Select("select * from OrderInf where sid = #{sid} order by id DESC")
    public List<OrderInf> findOrderBySid(Integer sid);
}
