package four.kjgz.logistics.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Staff {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer type;
    private String username;
    private String password;
    private String email;
    private String sex;
    private String staffNum;
    private String image;

    public Staff() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setStaffNum(String staffNum) {
        this.staffNum = staffNum;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getSex() {
        return sex;
    }

    public String getStaffNum() {
        return staffNum;
    }

    public String getImage() {
        return image;
    }
}
