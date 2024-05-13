package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import com.baomidou.mybatisplus.mapper.Wrapper;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 
 *
 * @author 
 * @email
 * @date 2021-01-30
 */
@TableName("shuifeixinxi")
public class ShuifeixinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShuifeixinxiEntity() {

	}

	public ShuifeixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    private Integer id;


    /**
     * 抄水表时间
     */
    @TableField(value = "money_time")
    private String moneyTime;


    /**
     * 用户id
     */
    @TableField(value = "yh_types")
    private Integer yhTypes;


    /**
     * 抄表数据
     */
    @TableField(value = "meterdata")
    private Integer meterdata;


    /**
     * 使用水表
     */
    @TableField(value = "sb_types")
    private Integer sbTypes;


    /**
     * 备注信息
     */
    @TableField(value = "notice_content")
    private String noticeContent;


    /**
     * 上月抄表数据
     */
    @TableField(value = "lastmeter")
    private Integer lastmeter;


    /**
     * 用水量
     */
    @TableField(value = "useyield")
    private Integer useyield;


    /**
     * 价格
     */
    @TableField(value = "money")
    private Double money;


    /**
     * 总价
     */
    @TableField(value = "maxmoney")
    private Double maxmoney;


    /**
     * 缴费时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy年MM月dd日")
	@DateTimeFormat
    @TableField(value = "notice_time")
    private Date noticeTime;


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
	 * 设置：抄水表时间
	 */
    public String getMoneyTime() {
        return moneyTime;
    }


    /**
	 * 获取：抄水表时间
	 */

    public void setMoneyTime(String moneyTime) {
        this.moneyTime = moneyTime;
    }
    /**
	 * 设置：用户id
	 */
    public Integer getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：用户id
	 */

    public void setYhTypes(Integer yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：抄表数据
	 */
    public Integer getMeterdata() {
        return meterdata;
    }


    /**
	 * 获取：抄表数据
	 */

    public void setMeterdata(Integer meterdata) {
        this.meterdata = meterdata;
    }
    /**
	 * 设置：使用水表
	 */
    public Integer getSbTypes() {
        return sbTypes;
    }


    /**
	 * 获取：使用水表
     * @param sbTypes
     */

    public void setSbTypes(Integer sbTypes) {
        this.sbTypes = sbTypes;
    }
    /**
	 * 设置：备注信息
	 */
    public String getNoticeContent() {
        return noticeContent;
    }


    /**
	 * 获取：备注信息
	 */

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }
    /**
	 * 设置：上月抄表数据
	 */
    public Integer getLastmeter() {
        return lastmeter;
    }


    /**
	 * 获取：上月抄表数据
	 */

    public void setLastmeter(Integer lastmeter) {
        this.lastmeter = lastmeter;
    }
    /**
	 * 设置：用水量
	 */
    public Integer getUseyield() {
        return useyield;
    }


    /**
	 * 获取：用水量
	 */

    public void setUseyield(Integer useyield) {
        this.useyield = useyield;
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
	 * 设置：总价
	 */
    public Double getMaxmoney() {
        return maxmoney;
    }


    /**
	 * 获取：总价
	 */

    public void setMaxmoney(Double maxmoney) {
        this.maxmoney = maxmoney;
    }
    /**
	 * 设置：缴费时间
	 */
    public Date getNoticeTime() {
        return noticeTime;
    }


    /**
	 * 获取：缴费时间
	 */

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

}
