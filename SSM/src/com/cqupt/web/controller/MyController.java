package com.cqupt.web.controller;

import com.cqupt.model.Customer;
import com.cqupt.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.sql.SQLException;

@Controller
@RequestMapping("/myController")
public class MyController {

    @Autowired
    private MyService myService;

    /**
     * 同步请求
     */
    @RequestMapping("/getCustomer")
    public String getCustomerById(@RequestParam Integer id, Model model) throws SQLException {

        //service抛出的异常不处理，继续抛出，留给exceptionHandler处理
        Customer customer = myService.getCustomerById(id);
        model.addAttribute(customer);
        return "testPage";
    }

    /**
     * 异步请求
     */
    @ResponseBody
    @RequestMapping("/updateCustomer")
    public String updateCustomer(@RequestBody @Valid Customer customer, BindingResult result) {

        System.out.println("进入方法");
        System.out.println(customer);

        myService.updateCustomer(customer);

        System.out.println("更新完成");
        return "Update Success!!!";
    }
}
