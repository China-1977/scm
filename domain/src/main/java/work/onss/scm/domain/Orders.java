package work.onss.scm.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name="orders")
public class Orders implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 合作商ID */
    private String merchantId ;
    /** 合作商名称 */
    private String merchantName ;
    /** 签约时间 */
    private Date signDatetime ;
    /** 状态;待提交 wait_submit 已提交/待接收 wait_cooperate 已接收/进行中 cooperating  已完成 finished 已拒绝 rejected */
    private String status ;
    /** 更新时间 */
    private Date updateDatetime ;
    /** 创建时间 */
    private Date createDatetime ;

}