package four.kjgz.logistics.bean;

import org.springframework.context.annotation.Bean;




public class Mycheck {
        public String checkaccess(String administratorsNum)
        {
            char first = administratorsNum.charAt(0);
            if (first!='1')//表示为管理员
            {
                return "不是管理员不能插入配送点";
            }
            else
            {
                return "成功";
            }
        }
}

