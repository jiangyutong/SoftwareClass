package four.kjgz.logistics.repository;

import four.kjgz.logistics.bean.chinas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;


public interface ChinasReposity extends JpaRepository<chinas,Integer> {

   public List<chinas> findByShengOrderByNumberDesc(String sheng);
   public List<chinas> findByShengAndNumber(String sheng, Integer number);
   public List<chinas> NumberBetween(Integer min, Integer max);
   public List<chinas> findByNumberLessThan(Integer max);//表示小于
   @Transactional
   public List<chinas> deleteByShengAndAndNumber(String sheng, Integer number);
   //public List<chinas> findByShengLike(String name);
   @Query("select u.id,u.number,u.sheng from  chinas u  where u.sheng like CONCAT('%',:name,'%') ")
   List<chinas> findByShengLike(@Param("name") String name);//模糊查询
    //原生SQL实现更新方法接口
    @Query(value = "update chinas set number=?1 where id=?2 ", nativeQuery = true)//有nativeQuery = true时，是可以执行原生sql语句，所谓原生sql，也就是说这段sql拷贝到数据库中，然后把参数值给一下就能运行了
    @Modifying
    @Transactional
    public void updateOne(Integer number, Integer id);


}
