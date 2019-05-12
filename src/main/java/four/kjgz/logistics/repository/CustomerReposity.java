package four.kjgz.logistics.repository;


import four.kjgz.logistics.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CustomerReposity extends JpaRepository<Customer,Integer> {
    public List<Customer> findByCustomerNumAndPassword(String customerNum,String assword);
    @Query(value = "select count(1) from customer ", nativeQuery = true)
    public Integer customerCount();
    @Transactional
    public List<Customer> deleteByCustomerNum(String CustomerNum);
    @Query(value = "select MAX(customer_num) from customer ", nativeQuery = true)
    public String findMaxNum();
    public List<Customer> findByCustomerNum(String num);
}
