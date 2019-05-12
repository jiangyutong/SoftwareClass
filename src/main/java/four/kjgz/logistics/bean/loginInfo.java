package four.kjgz.logistics.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "logininfo")
public class loginInfo {
    private String myusernum;
    private  String mypassword;
    private String result;
    private  String myusername;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMyusernum() {
        return myusernum;
    }

    public String getMyusername() {
        return myusername;
    }

    public void setMyusername(String myusername) {
        this.myusername = myusername;
    }

    public void setMyusernum(String myusernum) {
        this.myusernum = myusernum;
    }

    public String getMypassword() {
        return mypassword;
    }

    public void setMypassword(String mypassword) {
        this.mypassword = mypassword;
    }
}
