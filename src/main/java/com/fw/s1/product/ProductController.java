package com.fw.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fw.s1.util.ProductPager;

@Controller
@RequestMapping(value="/product/**")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping(value="list")
	public String getList(ProductPager productPager, Model model,String name,String division)throws Exception{
		System.out.println(productPager);
		System.out.println(productPager.getProductType());
		Long total = productService.getTotalCount(productPager);
		List<ProductVO> list = productService.getList(productPager);
		model.addAttribute("productList", list);
		model.addAttribute("totalCount",total);
		model.addAttribute("name",name);
		model.addAttribute("division", division);
		model.addAttribute("pager", productPager);
		return "/product/productList";
	}
}
