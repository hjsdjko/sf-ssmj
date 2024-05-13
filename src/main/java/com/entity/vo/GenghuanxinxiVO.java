package com.entity.vo;

import com.entity.GenghuanxinxiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email
 * @date 2021-01-30
 */
@TableName("genghuanxinxi")
public class GenghuanxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * id
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 更换用户
     */

    @TableField(value = "yh_types")
    private Integer yhTypes;


    /**
     * 更换水表
     */

    @TableField(value = "sb_types")
    private Integer sbTypes;


    /**
     * 更换原因
     */

    @TableField(value = "changecause")
    private String changecause;


    /**
     * 家庭住址
     */

    @TableField(value = "address")
    private String address;


    /**
     * 联系方式
     */

    @TableField(value = "contact")
    private String contact;


    /**
     * 是否通过 Search
     */

    @TableField(value = "whether_types")
    private Integer whetherTypes;


    /**
	 * 设置：id
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：id
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：更换用户
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：更换用户
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：更换水表
	 */
    public Integer getSbTypes() {
        return sbTypes;
    }


    /**
	 * 获取：更换水表
	 */

    public void setSbTypes(Integer sbTypes) {
        this.sbTypes = sbTypes;
    }
    /**
	 * 设置：更换原因
	 */
    public String getChangecause() {
        return changecause;
    }


    /**
	 * 获取：更换原因
	 */

    public void setChangecause(String changecause) {
        this.changecause = changecause;
    }
    /**
	 * 设置：家庭住址
	 */
    public String getAddress() {
        return address;
    }


    /**
	 * 获取：家庭住址
	 */

    public void setAddress(String address) {
        this.address = address;
    }
    /**
	 * 设置：联系方式
	 */
    public String getContact() {
        return contact;
    }


    /**
	 * 获取：联系方式
	 */

    public void setContact(String contact) {
        this.contact = contact;
    }
    /**
	 * 设置：是否通过 Search
	 */
    public Integer getWhetherTypes() {
        return whetherTypes;
    }


    /**
	 * 获取：是否通过 Search
	 */

    public void setWhetherTypes(Integer whetherTypes) {
        this.whetherTypes = whetherTypes;
    }

}
