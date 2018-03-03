package com.baomidou.springboot.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.springboot.entity.Brand;
import com.baomidou.springboot.entity.vo.BrandVO;
import com.baomidou.springboot.service.IBrandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author K神带你飞
 * @since 2018-02-02
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    /**
     * 分页 PAGE
     */
    @GetMapping("/list")
    public Page<Brand> list() {
        return brandService.selectPage(new Page<>(1, 5, "id", true));
//        return brandService.selectPage(new Page<>(2, 5, "sort_order", false));
    }

    /**
     * save or update
     */
    @PostMapping("/saveOrUpdate")
//    public void saveOrUpdate(@RequestBody BrandVO brandVO) {
    public void saveOrUpdate() {
        BrandVO brandVO = null;
        if (brandVO == null) {
            brandVO = new BrandVO();
//            brandVO.setId(1046012);
            brandVO.setId(1001000);
            brandVO.setSimpleDesc("测试saveOrUpdate方法====insert");
        } else {
            brandVO.setSimpleDesc("测试saveOrUpdate方法====update");
        }
        Brand entity = new Brand();
        BeanUtils.copyProperties(brandVO, entity);
        boolean result = brandService.insertOrUpdate(entity);
        System.out.println("=====>/brand/saveOrUpdate result:" + result);
        System.out.println("=====>ID:" + entity.getId());

//        brandService.insert(entity);
    }

    /**
     * logicDel
     */
    @PostMapping("/logicDel")
//    public void logicDel(@RequestBody BrandVO brandVO) {
    public void logicDel() {
        BrandVO brandVO = null;
        if (brandVO == null) {
            brandVO = new BrandVO();
//            brandVO.setId(1046012);
            brandVO.setId(1001000);
//            brandVO.setSimpleDesc("测试saveOrUpdate方法====insert");
        }
        Brand entity = new Brand();
        BeanUtils.copyProperties(brandVO, entity);
        boolean result = brandService.deleteById(entity);
        System.out.println("=====>/brand/logicDel result:" + result);
    }
}

