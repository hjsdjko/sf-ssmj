package com.entity.view;

import com.entity.GenghuanxinxiEntity;

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
@TableName("genghuanxinxi")
public class GenghuanxinxiView extends GenghuanxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	public GenghuanxinxiView() {

	}

	public GenghuanxinxiView(GenghuanxinxiEntity genghuanxinxiEntity) {
		try {
			BeanUtils.copyProperties(this, genghuanxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
