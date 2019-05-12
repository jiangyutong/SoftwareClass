package four.kjgz.logistics.repository;

import four.kjgz.logistics.bean.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StaffReposity extends JpaRepository<Staff,Integer> {
    public List<Staff> findByStaffNumAndPassword(String staffNum,String password);

    @Query(value = "select count(1) from staff ", nativeQuery = true)
    public Integer staffCount();
    @Transactional
    public  List<Staff> deleteByStaffNum(String staffNum);
    @Query(value = "select MAX(staff_num) from staff ", nativeQuery = true)
    public String findMaxNum();
    public List<Staff> findByStaffNum(String num);
}
