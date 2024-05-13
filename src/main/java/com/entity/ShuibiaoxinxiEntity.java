package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 
 *
 * @author 
 * @email
 * @date 2021-01-30
 */
@TableName("shuibiaoxinxi")
public class ShuibiaoxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShuibiaoxinxiEntity() {

	}

	public ShuibiaoxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Integer id;


    /**
     * 水表信息
     */
    @TableField(value = "sbname")
    private String sbname;


    /**
     * 价格
     */
    @TableField(value = "money")
    private Double money;


    /**
     * 新增时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "money_time")
    private Date moneyTime;


    /**
	 * 设置：
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：水表信息
	 */
    public String getSbname() {
        return sbname;
    }


    /**
	 * 获取：水表信息
	 */

    public void setSbname(String sbname) {
        this.sbname = sbname;
    }
    /**
	 * 设置：价格
	 */
    public Double getMoney() {
        return money;
    }


    /**
	 * 获取：价格
	 */

    public void setMoney(Double money) {
        this.money = money;
    }
    /**
	 * 设置：新增时间
	 */
    public Date getMoneyTime() {
        return moneyTime;
    }


    /**
	 * 获取：新增时间
	 */

    public void setMoneyTime(Date moneyTime) {
        this.moneyTime = moneyTime;
    }

}
