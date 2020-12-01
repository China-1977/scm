package work.onss.domain;

import lombok.Data;

/**
 * 仓库
 */
@Data
public class Warehouse {

    private String id;
    private String name;
    /**
     * 仓库联系姓名
     */
    private String contactName;
    /**
     * 仓库联系电话
     */
    private String contactPhone;
    /**
     * 仓库联系地址
     */
    private String contactAddress;
    /**
     * 仓库联系邮箱
     */
    private String contactEmail;
}
