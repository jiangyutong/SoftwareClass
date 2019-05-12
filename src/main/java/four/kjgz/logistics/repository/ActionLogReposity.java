package four.kjgz.logistics.repository;

import four.kjgz.logistics.bean.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionLogReposity extends JpaRepository<ActionLog,Integer> {
}
