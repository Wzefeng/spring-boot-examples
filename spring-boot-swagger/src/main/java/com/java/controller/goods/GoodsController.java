package com.java.controller.goods;

import com.java.bean.Goods;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 商品Controller
 *
 * @author wangzefeng
 * @date 2019/11/9 22:09
 */
@Api(tags = "商品管理")
@RestController()
@RequestMapping("/goods")
public class GoodsController {

    private static Map<Long, Goods> goods = Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取商品列表", notes = "")
    @GetMapping("")
    public List<Goods> getGoodsList() {

        return new ArrayList<>(goods.values());
    }
}
