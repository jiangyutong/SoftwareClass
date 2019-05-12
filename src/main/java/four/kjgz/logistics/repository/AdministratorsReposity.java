package four.kjgz.logistics.repository;

import four.kjgz.logistics.bean.Administrators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AdministratorsReposity extends JpaRepository<Administrators,Integer> {
    public List<Administrators> findByAdministratorsNumAndPassword(String administratorsNum,String password);

    @Query(value = "select count(1) from administrators ", nativeQuery = true)
    public Integer administratorsCount();
    @Transactional
    public List<Administrators> deleteByAdministratorsNum(String administratorsNum);
    @Query(value = "select MAX(administrators_num) from administrators ", nativeQuery = true)
    public String findMaxNum();
    public List<Administrators> findByAdministratorsNum(String num);


}
