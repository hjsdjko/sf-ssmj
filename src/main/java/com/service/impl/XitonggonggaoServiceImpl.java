package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.XitonggonggaoDao;
import com.entity.XitonggonggaoEntity;
import com.service.XitonggonggaoService;
import com.entity.view.XitonggonggaoView;

/**
 * 系统公告 服务实现类
 * @author 
 * @since 2021-01-30
 */
@Service("xitonggonggaoService")
@Transactional
public class XitonggonggaoServiceImpl extends ServiceImpl<XitonggonggaoDao, XitonggonggaoEntity> implements XitonggonggaoService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<XitonggonggaoView> page =new Query<XitonggonggaoView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
