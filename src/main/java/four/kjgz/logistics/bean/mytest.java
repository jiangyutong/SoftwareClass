package four.kjgz.logistics.bean;

import org.hibernate.annotations.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class mytest {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String sex;
    private String administratorsNum;
    private String image;

    public mytest() {
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

    public String getAdministratorsNum() {
        return administratorsNum;
    }

    public String getImage() {
        return image;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setAdministratorsNum(String administratorsNum) {
        this.administratorsNum = administratorsNum;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
