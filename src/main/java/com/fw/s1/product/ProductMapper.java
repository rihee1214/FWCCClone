package com.fw.s1.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
	
	public List<ProductVO> getList(ProductVO productVO) throws Exception;
	public ProductVO getSelect(ProductVO productVO) throws Exception;
	public int setInsert(ProductVO productVO) throws Exception;
	public int setUpdate(ProductVO productVO) throws Exception;
	public int setDelete(ProductVO productVO) throws Exception;

}
