package work.onss.scm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity(name="member")
public class Member implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 手机号 */
    private String phone ;
    /** 姓名 */
    private String name ;
    /** 描述 */
    private String description ;
    /** 身份证号 */
    private String cardNumber ;
    /** 身份证照片 */
    private String cardCopy ;
    /** 创建时间 */
    private Date createDatetime ;
    /** 更新时间 */
    private Date updateDatetime ;

    /** 主键 */
    public String getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(String id){
        this.id = id;
    }
    /** 手机号 */
    public String getPhone(){
        return this.phone;
    }
    /** 手机号 */
    public void setPhone(String phone){
        this.phone = phone;
    }
    /** 姓名 */
    public String getName(){
        return this.name;
    }
    /** 姓名 */
    public void setName(String name){
        this.name = name;
    }
    /** 描述 */
    public String getDescription(){
        return this.description;
    }
    /** 描述 */
    public void setDescription(String description){
        this.description = description;
    }
    /** 身份证号 */
    public String getCardNumber(){
        return this.cardNumber;
    }
    /** 身份证号 */
    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }
    /** 身份证照片 */
    public String getCardCopy(){
        return this.cardCopy;
    }
    /** 身份证照片 */
    public void setCardCopy(String cardCopy){
        this.cardCopy = cardCopy;
    }
    /** 创建时间 */
    public Date getCreateDatetime(){
        return this.createDatetime;
    }
    /** 创建时间 */
    public void setCreateDatetime(Date createDatetime){
        this.createDatetime = createDatetime;
    }
    /** 更新时间 */
    public Date getUpdateDatetime(){
        return this.updateDatetime;
    }
    /** 更新时间 */
    public void setUpdateDatetime(Date updateDatetime){
        this.updateDatetime = updateDatetime;
    }
}