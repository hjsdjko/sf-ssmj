package com.entity.model;

import com.entity.GenghuanxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @author 
 * @email
 * @date 2021-01-30
 */
public class GenghuanxinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * id
     */
    private Integer id;


    /**
     * 更换用户
     */
    private Integer yhTypes;


    /**
     * 更换水表
     */
    private Integer sbTypes;


    /**
     * 更换原因
     */
    private String changecause;


    /**
     * 家庭住址
     */
    private String address;


    /**
     * 联系方式
     */
    private String contact;


    /**
     * 是否通过 Search
     */
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
