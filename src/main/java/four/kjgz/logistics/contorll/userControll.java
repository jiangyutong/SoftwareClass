package four.kjgz.logistics.contorll;

import four.kjgz.logistics.repository.AdministratorsReposity;
import four.kjgz.logistics.repository.CustomerReposity;
import four.kjgz.logistics.repository.StaffReposity;
import org.springframework.beans.factory.annotation.Autowired;

public class userControll {
    @Autowired
    AdministratorsReposity administratorsReposity;
    @Autowired
    CustomerReposity customerReposity;
    @Autowired
    StaffReposity staffReposity;
}
