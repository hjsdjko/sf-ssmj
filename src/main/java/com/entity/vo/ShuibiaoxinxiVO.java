package com.entity.vo;

import com.entity.ShuibiaoxinxiEntity;
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
@TableName("shuibiaoxinxi")
public class ShuibiaoxinxiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 
     */

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
