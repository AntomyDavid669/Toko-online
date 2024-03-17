package com.projectbaru.TokoOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AdminController {
  @RequestMapping("/admin")
    public String loadadmin() {
		return "admin/orders.html";
	}

  @RequestMapping("/admin/order")
    public String loadadminorder() {
		return "admin/orders.html";
	}

  @RequestMapping("/admin/product")
    public String laodproduct() {
		return "admin/product/product.html";
	}

  @RequestMapping("/admin/category")
    public String loadcategory() {
		return "admin/category/category.html";
	}
}
