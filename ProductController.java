package jp.co.internous.kabuki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.kabuki.model.domain.MstProduct;
import jp.co.internous.kabuki.model.mapper.MstProductMapper;
import jp.co.internous.kabuki.model.session.LoginSession;

@Controller
@RequestMapping("/kabuki/product")
public class ProductController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private MstProductMapper productMapper;

	@RequestMapping("/{id}")
	public String index(@PathVariable("id") long id, Model m) {	
		MstProduct product = productMapper.findById(id);
		m.addAttribute("product", product);
		m.addAttribute("loginSession",loginSession);
		
		return "product_detail";
	}
	
}