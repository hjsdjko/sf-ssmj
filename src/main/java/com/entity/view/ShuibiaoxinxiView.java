package com.entity.view;

import com.entity.ShuibiaoxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;

/**
 * 
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email
 * @date 2021-01-30
 */
@TableName("shuibiaoxinxi")
public class ShuibiaoxinxiView extends ShuibiaoxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public ShuibiaoxinxiView() {

	}

	public ShuibiaoxinxiView(ShuibiaoxinxiEntity shuibiaoxinxiEntity) {
		try {
			BeanUtils.copyProperties(this, shuibiaoxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
