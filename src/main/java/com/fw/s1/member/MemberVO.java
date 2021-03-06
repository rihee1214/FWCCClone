package com.fw.s1.member;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fw.s1.address.AddressVO;

import com.fw.s1.mileage.MileageVO;

import lombok.Data;

@Data
public class MemberVO implements UserDetails{
	
	@NotEmpty
	@Length(min = 4, max = 16)
	private String username;
	@NotEmpty
	@Length(min = 4, max = 16)
	private String password;
	private String passwordCheck;
	@NotEmpty
	private String name;
	@Length(min = 3)
	private String phone;
	
	private String phone0;
	private String phone1;
	private String phone2;
	
	@Email
	private String email;
	private String birth;
	private boolean smsAgree;
	private boolean emailAgree;
	private boolean enabled;
	
	private List<RoleVO> roles;
	
	private String zipCode;
	private String basicAddr;
	private String detailAddr;
	
	private String email1;
	private String email2;
	private String email3;
	private MileageVO mileageVO;

	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(RoleVO roleVO:roles) {
			authorities.add(new SimpleGrantedAuthority(roleVO.getRoleName()));
		}
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.enabled;
	}

	public void emailSeperator() {
		String[] templist = this.email.split("[@\\.]");
		this.email1 = templist[0];
		this.email2 = templist[1];
		this.email3 = templist[2];
	}
}
