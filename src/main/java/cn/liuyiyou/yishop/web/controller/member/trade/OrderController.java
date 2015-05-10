/**
 * 
 * 惠购 - 惠购网 - www.huiget.com - 特别会购！
 * Copyright © 2014 惠购 www.huiget.com 版权所有
 */
package cn.liuyiyou.yishop.web.controller.member.trade;

import cn.liuyiyou.yishop.web.form.member.trade.OrderForm;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author yaofang
 * @version $Id: OrderController.java, v 0.1 2014年10月3日 下午8:35:51 yaofang Exp $
 */
@Controller
@RequestMapping(value = "/member/trade/")
public class OrderController {

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orders(@ModelAttribute("form") OrderForm form) {

        return "member/trade/orders";

    }

}
