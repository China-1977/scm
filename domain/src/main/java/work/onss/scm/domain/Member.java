package work.onss.scm.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@Entity(name="member")
public class Member implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private Long id ;
    /** 手机号 */
    private String phone ;
    /** 密码 */
    private String password ;
    /** 姓名 */
    private String name ;
    /** 描述 */
    private String description ;
    /** 身份证号 */
    private String cardNumber ;
    /** 身份证照片 */
    private String cardCopy ;
    /** 创建时间 */
    private LocalDateTime createDatetime ;
    /** 更新时间 */
    private LocalDateTime updateDatetime ;
}