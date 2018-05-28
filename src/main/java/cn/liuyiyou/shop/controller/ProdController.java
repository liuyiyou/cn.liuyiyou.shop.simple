package cn.liuyiyou.shop.controller;

import cn.liuyiyou.shop.req.ReqBody;
import cn.liuyiyou.shop.resp.Result;
import cn.liuyiyou.shop.service.IProdService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static cn.liuyiyou.shop.resp.ResultGenerator.genSuccessResult;

/***
 * @author: liuyiyou
 * @date: 2018/4/3
 */
@RestController
@Slf4j
@RequestMapping("/prod")
public class ProdController {

    @Autowired
    private IProdService prodService;


    @PostMapping("list")
    public Result list(@RequestBody ReqBody reqBody) {
        return genSuccessResult(prodService.getProdsPage(reqBody.page, reqBody.pageSize));
    }

    @GetMapping("{id}")
    public ModelAndView prod(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/prod/detail");
        return mv;
    }
}
