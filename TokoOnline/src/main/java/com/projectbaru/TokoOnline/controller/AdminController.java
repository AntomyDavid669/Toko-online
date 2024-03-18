package com.projectbaru.TokoOnline.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.annotation.MultipartConfig;


@Controller
@MultipartConfig
public class AdminController {
  @Autowired
  UserDetailsService userDetailsService;

  @RequestMapping("/admin")
      public String adminPage (Model model, Principal principal){
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        model.addAttribute("user", userDetails);
        return "/admin/orders";
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
