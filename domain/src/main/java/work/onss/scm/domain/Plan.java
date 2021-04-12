package work.onss.scm.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name="plan")
public class Plan implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 计划编号;年月日+存货编码 */
    private String planCode ;
    /** 产品ID */
    private String productId ;
    /** 产品编号 */
    private String productCode ;
    /** 产品名称 */
    private String productName ;
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    private String type ;
    /** 开始时间 */
    private Date startDate ;
    /** 截止时间 */
    private Date endDate ;
    /** 状态;准备 read、开始 start、暂停 suspend、完成 finish、停止 stop */
    private String status ;
    /** 计划数量 */
    private Long planQuantity ;
    /** 已分配数量 */
    private Long allocatedQuantity ;
    /** 已完成数量 */
    private Long completedQuantity ;
    /** 更新时间 */
    private Date upateDatetime ;
    /** 创建时间 */
    private Date crateDatetime ;
}