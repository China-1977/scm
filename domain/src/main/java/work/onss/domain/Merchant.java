package work.onss.domain;

import lombok.Data;

import java.util.List;

/**
 * 商户
 */
@Data
public class Merchant {
    /**
     * 商户ID
     */
    private String id;
    /**
     * 商户简称
     */
    private String shortName;
    /**
     * 商户全称
     */
    private String fullName;
    /**
     * 注册号/统一社会信用代码
     */
    private String licenseNumber;
    /**
     * 营业执照照片
     */
    private String licenseCopy;
    /**
     * 个体户经营者/法人姓名
     */
    private String legalPerson;
    /**
     * 开户银行全称（含支行]
     */
    private String bankName;
    /**
     * 开户名称
     */
    private String accountName;
    /**
     * 银行账号
     */
    private String accountNumber;
    /**
     * 开户银行
     */
    private String accountBank;
    /**
     * 联系姓名
     */
    private String contactName;
    /**
     * 联系电话
     */
    private String contactPhone;
    /**
     * 联系地址
     */
    private String contactAddress;
    /**
     * 联系邮箱
     */
    private String contactEmail;
    /**
     * 企业微信USERID
     */
    List<String> userid;
}