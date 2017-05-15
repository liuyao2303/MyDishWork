package test;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by xiaoliu on 2017/5/15.
 */

@Entity(name = "user_login_info")
public class UserLoginDmo {

    @Id
    @GenericGenerator(name = "id_gen",strategy = "identity")
    @GeneratedValue(generator = "id_gen")
    @Column(name = "id")
    private Integer id;


    @OneToOne(targetEntity = UserInfoDmo.class)
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private UserInfoDmo userInfoDmo;

    @Column(name = "password",length = 128,nullable = false)
    private String password;

    @Column(name = "open_id")
    private long openId;

    @Column(name = "status",length = 2, nullable = false)
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getOpenId() {
        return openId;
    }

    public void setOpenId(long openId) {
        this.openId = openId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
