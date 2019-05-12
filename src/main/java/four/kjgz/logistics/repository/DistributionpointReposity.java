package four.kjgz.logistics.repository;

import four.kjgz.logistics.bean.Distributionpoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DistributionpointReposity extends JpaRepository<Distributionpoint,Integer> {
    public List<Distributionpoint> findByName(String name);
    public List<Distributionpoint> findByLocation(String location);
    public List<Distributionpoint> findByNameAndLocation(String name,String location);
    @Transactional
    public List<Distributionpoint> deleteByNameAndLocation(String name,String location);
}
