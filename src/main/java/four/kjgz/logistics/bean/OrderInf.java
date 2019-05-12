package four.kjgz.logistics.bean;

public class OrderInf {
    private Integer id;
    private String ordernum;
    private String nowlocation;
    private String nextlocation;
    private Integer sid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getNowlocation() {
        return nowlocation;
    }

    public void setNowlocation(String nowlocation) {
        this.nowlocation = nowlocation;
    }

    public String getNextlocation() {
        return nextlocation;
    }

    public void setNextlocation(String nextlocation) {
        this.nextlocation = nextlocation;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }
}
