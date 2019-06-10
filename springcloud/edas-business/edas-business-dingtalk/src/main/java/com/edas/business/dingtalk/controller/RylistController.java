package com.edas.business.dingtalk.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edas.business.dingtalk.entity.ShopwwiRylist;
import com.edas.business.dingtalk.service.ShopwwiRylistService;
import com.edas.edascommon.utils.web.RetResponse;
import com.edas.edascommon.utils.web.RetResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("rylist")
public class RylistController {

   @Autowired
    private ShopwwiRylistService shopwwiRylistService;

    @RequestMapping(value = "/selectById", method = { RequestMethod.GET, RequestMethod.POST })
    public RetResult<ShopwwiRylist> selectById(HttpServletRequest request) throws Exception {

        String id = request.getParameter("id");

        ShopwwiRylist shopwwiRylist = shopwwiRylistService.selectById(id);

        return RetResponse.makeOKRsp(shopwwiRylist);
    }

    @RequestMapping(value = "/byId", method = { RequestMethod.GET, RequestMethod.POST })
    public ShopwwiRylist byId(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        ShopwwiRylist shopwwiRylist = shopwwiRylistService.selectById(id);
        return shopwwiRylist;
    }


    @RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
    public RetResult<PageInfo<ShopwwiRylist>> list(HttpServletRequest request) throws Exception {

        String page = request.getParameter("page");
        String size = request.getParameter("size");

        int s = Integer.parseInt(size);
        int p = Integer.parseInt(page);

        PageHelper.startPage(p > 0 ? p : 1, s > 0 ? s : 15);
        List<ShopwwiRylist> list = shopwwiRylistService.selectAll();
        PageInfo<ShopwwiRylist> pageInfo = new PageInfo<ShopwwiRylist>(list);

        return RetResponse.makeOKRsp(pageInfo);
    }

}
