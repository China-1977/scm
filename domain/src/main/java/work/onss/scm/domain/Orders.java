package work.onss.scm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Entity(name="orders")
public class Orders implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private Long id ;
    /** 合作商ID */
    private String merchantId ;
    /** 合作商名称 */
    private String merchantName ;
    /** 签约时间 */
    private LocalDateTime signDatetime ;
    /** 状态;待提交 wait_submit 已提交/待接收 wait_cooperate 已接收/进行中 cooperating  已完成 finished 已拒绝 rejected */
    private StatusEnum status ;
    /** 更新时间 */
    private LocalDateTime updateDatetime ;
    /** 创建时间 */
    private LocalDateTime createDatetime ;

    @Getter
    @AllArgsConstructor
    public static enum StatusEnum implements Serializable,Cloneable{
        WAIT_SUBMIT("待提交"),
        WAIT_COOPERATE("待接收"),
        COOPERATING("进行中"),
        FINISHED("已完成"),
        REJECTED("已拒绝");
        private final String message;
    }
}