package com.fw.s1.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fw.s1.member.MemberVO;
import com.google.gson.Gson;

@Controller
@RequestMapping("/address/**")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@ResponseBody
	@GetMapping("getSelectOne")
	public String getSelectOne(AddressVO addressVO, Authentication authentication)throws Exception{
		addressVO.setUsername(((UserDetails)authentication.getPrincipal()).getUsername());
		addressVO = addressService.getSelectOne(addressVO);
		
		if(addressVO==null) {
			return "";
		}
		addressVO.phoneSeperator();
		Gson gson = new Gson();
		
		return gson.toJson(addressVO);
	}
	
	@ResponseBody
	@GetMapping("deleteSelect")
	public Long deleteAddress(long[] addrNums, Authentication authentication)throws Exception{
		List<AddressVO> addressVOs = new ArrayList<>();
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(((UserDetails)authentication.getPrincipal()).getUsername());
		
		for(long addrNum : addrNums) {
			AddressVO addressVO = new AddressVO();
			addressVO.setAddrNum(addrNum);
			addressVO.setUsername(memberVO.getUsername());
			addressVOs.add(addressVO);
		}
		
		return addressService.deleteSelect(addressVOs);
	}
	
	@ResponseBody
	@GetMapping("getAddressList")
	public String[] getAddressList(Authentication authentication)throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername(((UserDetails)authentication.getPrincipal()).getUsername());
		List<AddressVO> list = addressService.getAddressList(memberVO);
		int length = list.size();
		
		if(length==0) {
			String[] def = {""};
			return def;
		}
		
		String[] results = new String[length-1];
		
		int temp = 0;
		Gson gson = new Gson();
		for(int i = 0 ; i < length; i++) {
			AddressVO addressVO = list.get(i);
			if(addressVO.getOrderAddr()) {
				addressVO.concatAddress();
				results[temp+i] = gson.toJson(addressVO);
			}else {
				temp=-1;
			}
		}
		
		return results;
	}
	
	@ResponseBody
	@GetMapping("updateAddress")
	@Transactional(rollbackFor = Exception.class)
	public Long updateAddress(AddressVO addressVO, Authentication authentication)throws Exception{
		addressVO.setUsername(((UserDetails)authentication.getPrincipal()).getUsername());
		Long result = addressService.beforeAddreess(addressVO);
		
		if(result<1) {
			return result;
		}
		
		result = addressService.updateAddress(addressVO);
		return result;
	}
	
	@ResponseBody
	@GetMapping("setAddress")
	@Transactional(rollbackFor = Exception.class)
	public Long setAddress(AddressVO addressVO, Authentication authentication)throws Exception{
		addressVO.setUsername(((UserDetails)authentication.getPrincipal()).getUsername());
		addressService.beforeAddreess(addressVO);
		
		return addressService.setAddress(addressVO);
	}
	
	@ResponseBody
	@GetMapping("getSelectRecent")
	public String getSelectRecent(Authentication authentication)throws Exception{
		AddressVO addressVO = new AddressVO();
		addressVO.setUsername(((UserDetails)authentication.getPrincipal()).getUsername());
		
		Gson gson = new Gson();
		addressVO = addressService.getSelectRecent(addressVO);
		
		if(addressVO==null) {
			return "";
		}
		addressVO.phoneSeperator();
		
		return gson.toJson(addressVO);
	}
	
	@ResponseBody
	@GetMapping("checkCount")
	public Long checkCount(Authentication authentication)throws Exception{
		AddressVO addressVO = new AddressVO();
		addressVO.setUsername(((UserDetails)authentication.getPrincipal()).getUsername());
		return addressService.checkCount(addressVO);
	}

}
