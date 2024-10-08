package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.YonghuxinxiEntity;
import com.service.YonghuxinxiService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.GenghuanxinxiEntity;

import com.service.GenghuanxinxiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 
 * 后端接口
 * @author
 * @email
 * @date 2021-01-30
*/
@RestController
@Controller
@RequestMapping("/genghuanxinxi")
public class GenghuanxinxiController {
    private static final Logger logger = LoggerFactory.getLogger(GenghuanxinxiController.class);

    @Autowired
    private GenghuanxinxiService genghuanxinxiService;

    @Autowired
    private YonghuxinxiService yonghuxinxiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;
        if(role.equals("用户")){
            params.put("yh",request.getSession().getAttribute("userId"));
            page = genghuanxinxiService.queryPage(params);
        }else{
            page = genghuanxinxiService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        GenghuanxinxiEntity genghuanxinxi = genghuanxinxiService.selectById(id);
        if(genghuanxinxi!=null){
            return R.ok().put("data", genghuanxinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody GenghuanxinxiEntity genghuanxinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<GenghuanxinxiEntity> queryWrapper = new EntityWrapper<GenghuanxinxiEntity>()
            .eq("yh_types", genghuanxinxi.getYhTypes())
            .eq("sb_types", genghuanxinxi.getSbTypes());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        GenghuanxinxiEntity genghuanxinxiEntity = genghuanxinxiService.selectOne(queryWrapper);
        if(genghuanxinxiEntity==null){
            genghuanxinxi.setWhetherTypes(2);
            genghuanxinxiService.insert(genghuanxinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 是否同意
    */
    @RequestMapping("/sifoutongyi")
    public R sifoutongyi(@RequestBody Integer id){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        GenghuanxinxiEntity genghuan = genghuanxinxiService.selectById(id);
        genghuan.setWhetherTypes(1);
        YonghuxinxiEntity yonghuxinxi = yonghuxinxiService.selectById(genghuan.getYhTypes());
        yonghuxinxi.setSbTypes(genghuan.getSbTypes());
        yonghuxinxiService.updateById(yonghuxinxi);
        genghuanxinxiService.updateById(genghuan);
        return R.ok();
    }
    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        genghuanxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

