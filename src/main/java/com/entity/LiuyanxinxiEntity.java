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
@TableName("liuyanxinxi")
public class LiuyanxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public LiuyanxinxiEntity() {

	}

	public LiuyanxinxiEntity(T t) {
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
     * 留言信息
     */
    @TableField(value = "note")
    private String note;


    /**
     * 留言人id
     */
    @TableField(value = "yhnote")
    private String yhnote;


    /**
     * 留言时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "note_time")
    private Date noteTime;


    /**
     * 回复
     */
    @TableField(value = "reply")
    private String reply;


    /**
     * 回复人id
     */
    @TableField(value = "glreply")
    private String glreply;


    /**
     * 
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "reply_time")
    private Date replyTime;


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
	 * 设置：留言信息
	 */
    public String getNote() {
        return note;
    }


    /**
	 * 获取：留言信息
	 */

    public void setNote(String note) {
        this.note = note;
    }
    /**
	 * 设置：留言人id
	 */
    public String getYhnote() {
        return yhnote;
    }


    /**
	 * 获取：留言人id
	 */

    public void setYhnote(String yhnote) {
        this.yhnote = yhnote;
    }
    /**
	 * 设置：留言时间
	 */
    public Date getNoteTime() {
        return noteTime;
    }


    /**
	 * 获取：留言时间
	 */

    public void setNoteTime(Date noteTime) {
        this.noteTime = noteTime;
    }
    /**
	 * 设置：回复
	 */
    public String getReply() {
        return reply;
    }


    /**
	 * 获取：回复
	 */

    public void setReply(String reply) {
        this.reply = reply;
    }
    /**
	 * 设置：回复人id
	 */
    public String getGlreply() {
        return glreply;
    }


    /**
	 * 获取：回复人id
	 */

    public void setGlreply(String glreply) {
        this.glreply = glreply;
    }
    /**
	 * 设置：
	 */
    public Date getReplyTime() {
        return replyTime;
    }


    /**
	 * 获取：
	 */

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

}
