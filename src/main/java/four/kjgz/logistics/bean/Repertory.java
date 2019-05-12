package four.kjgz.logistics.bean;

public class Repertory {
    private Integer id;
    private Integer capity;
    private Integer monthOut;
    private Integer monthInput;
    private String location;
    private Integer nowCapity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCapity() {
        return capity;
    }

    public void setCapity(Integer capity) {
        this.capity = capity;
    }

    public Integer getMonthOut() {
        return monthOut;
    }

    public void setMonthOut(Integer monthOut) {
        this.monthOut = monthOut;
    }

    public Integer getMonthInput() {
        return monthInput;
    }

    public void setMonthInput(Integer monthInput) {
        this.monthInput = monthInput;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getNowCapity() {
        return nowCapity;
    }

    public void setNowCapity(Integer nowCapity) {
        this.nowCapity = nowCapity;
    }
}
