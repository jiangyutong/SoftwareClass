package four.kjgz.logistics.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Administrators {
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String sex;
    private String administratorsNum;
    private String image;

    public void setAdministratorsNum(String administratorsNum) {
        this.administratorsNum = administratorsNum;
    }

    public String getAdministratorsNum() {
        return administratorsNum;
    }

    public Administrators() {
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

    public String getEmail(String email) {
        return this.email;
    }

    public String getSex() {
        return sex;
    }



    public String getImage() {
        return image;
    }


}
