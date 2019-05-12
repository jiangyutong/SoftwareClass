package four.kjgz.logistics.repository;

import four.kjgz.logistics.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface EmployeeReposity extends JpaRepository<Employee,Integer> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update employee p set p.status =?1 where p.id = ?2",nativeQuery = true)
    public  int updateStatusById(String status, String id);

}
