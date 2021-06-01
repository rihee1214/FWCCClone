package com.fw.s1.product;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fw.s1.product.ProductMapper;
import com.fw.s1.product.ProductVO;
@SpringBootTest
class ProductMapperTest {
	
	@Autowired
	private ProductMapper productMapper;

//	@Test
	void getListTest() throws Exception {
		ProductVO vo = new ProductVO();
//		List<ProductVO> list = productMapper.getList(vo);
//		System.out.println(list.size());
//		assertNotNull(list);
	}
	
//	@Test
	void getSelectTest() throws Exception{
		ProductVO vo = new ProductVO();
		vo.setProductNum(33L);
		vo = productMapper.getSelect(vo);
		System.out.println(vo.getProductTitle());
		
		assertNotNull(vo);
		
	}
	
	@Test
	void setInsertTest() throws Exception{
		int total=0;
		String name = "top-short";
		for(int i=0;i<300;i++) {
			ProductVO vo = new ProductVO();
			vo.setProductTitle(name+i);
			vo.setProductPrice((long) ((i+1)*10000));
			vo.setProductContents("productContents"+i);
			vo.setCollab("collab"+i%3);
			vo.setProductType(name);
			int result = productMapper.setInsert(vo);
			total += result;
			System.out.println("r : "+result+" t : "+total);
			if(i%10==0) {
				Thread.sleep(1000);
			}
		}
		assertNotEquals(0, total);
	}
	
//	@Test
	void setUpdateTest() throws Exception {
		ProductVO vo = new ProductVO();
		vo.setProductTitle("Change-productTitle");
		vo.setCollab("Change-collab");
		vo.setProductNum(36L);
		vo.setProductType("Change-productType");
		int result = productMapper.setUpdate(vo);
	}
	
//	@Test
	void setDeleteTest() throws Exception{
		ProductVO vo = new ProductVO();
		vo.setProductNum(36L);
		int result = productMapper.setDelete(vo);
		assertNotEquals(0, result);
	}
}
