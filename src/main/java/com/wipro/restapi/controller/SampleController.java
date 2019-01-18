package com.wipro.restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.restapi.model.User;
import com.wipro.restapi.repository.UserRepository;



@RestController
@RequestMapping("/users")
public class SampleController {
	
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/getDetails2")
	public List<User> getBankDetails2(@RequestHeader(value="mobno") String mobno)
	{
		
		System.out.println("Value : " + mobno);
		User details=new User();
		
		
		details.setFirstName("asd");
		details.setLastName("srt");
		
		/*BankInfo bankinfo=new BankInfo();
		
		bankinfo.setAccountName("name");
		bankinfo.setAccountNo("121");
		bankinfo.setBankName("ras");
		
		List<BankInfo> banklist=new ArrayList<BankInfo>();
		banklist.add(bankinfo);
		
		details.setBankInfo(banklist);*/
				
				
		
		return  userRepository.findAll();
	}
	
	
	@RequestMapping("/getDetails")
	public User getBankDetails(@RequestHeader(value="mobno") String mobno)
	{
		
		System.out.println("Value : " + mobno);
		User details=new User();
		
		
		details.setFirstName("asd");
		details.setLastName("srt");
		
		/*BankInfo bankinfo=new BankInfo();
		
		bankinfo.setAccountName("name");
		bankinfo.setAccountNo("121");
		bankinfo.setBankName("ras");
		
		List<BankInfo> banklist=new ArrayList<BankInfo>();
		banklist.add(bankinfo);
		
		details.setBankInfo(banklist);*/
				
				
		
		return details;
	}
	
	/*@GetMapping("/welcome/user")
	//@RequestMapping("/welcome/user")
	public AllBankDetails getBankDetails2(@RequestHeader(value="name") String mobno)
	{
		
		System.out.println("Value : " + mobno);
		AllBankDetails details=new AllBankDetails();
		
		
		details.setName("asd");
		details.setAddress("srt");
		
		BankInfo bankinfo=new BankInfo();
		
		bankinfo.setAccountName("name");
		bankinfo.setAccountNo("121");
		bankinfo.setBankName("ras");
		
		List<BankInfo> banklist=new ArrayList<BankInfo>();
		banklist.add(bankinfo);
		
		details.setBankInfo(banklist);
				
				
		
		return details;
	}*/

}
