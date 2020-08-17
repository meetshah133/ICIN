package com.example.springcore;



import static org.junit.Assert.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;
//import org.junit.jupiter.api.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.icin.exceptions.AccountNotFoundException;


//@TestMethodOrder(OrderAnnotation.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestWebApp extends SpringcoreApplicationTests {

	/*@Test
	void test() {
		fail("Not yet implemented");
	}*/
	
	@Autowired
	private WebApplicationContext webApplicationContext;


	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
	}
	
	
	@Test()
	public void aTesthello() throws Exception{
		mockMvc.perform(get("/hello")).andExpect(status().isOk()).andDo(print());
	}

	
	@Test //test register user1
	public void bTestRegister() throws Exception {
		
		String content = "{\r\n" + 
				"    \"fullname\":\"test\",\r\n" + 
				"    \"surname\":\"t\",\r\n" + 
				"    \"mailid\":\"test@gmail.com\",\r\n" + 
				"    \"phonenumber\":9876543210,\r\n" + 
				"    \"address\":\"chennai\",\r\n" + 
				"    \"password\":\"test1234\"\r\n" + 
				"    \r\n" + 
				"}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register")
				.accept(MediaType.APPLICATION_JSON_VALUE).content(content).contentType(MediaType.APPLICATION_JSON_VALUE);
		ResultActions result =  mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());	
	}
	
	
	@Test //test register user2
	public void cTestRegister1() throws Exception {
		String content = "{\r\n" + 
				"    \"fullname\":\"test1\",\r\n" + 
				"    \"surname\":\"t1\",\r\n" + 
				"    \"mailid\":\"test1@gmail.com\",\r\n" + 
				"    \"phonenumber\":1234567890,\r\n" + 
				"    \"address\":\"chennai\",\r\n" + 
				"    \"password\":\"testing1234\"\r\n" + 
				"    \r\n" + 
				"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/register")
				.accept(MediaType.APPLICATION_JSON_VALUE).content(content).contentType(MediaType.APPLICATION_JSON_VALUE);
		
		ResultActions result =  mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
	}
	

	
	@Test //test admin login
	public void dTestAdmin1() throws Exception {
		
		String content = "{\r\n" + 
				"    \"emailid\":\"admin\",\r\n" + 
				"    \"password\":\"admin\"\r\n" + 
				"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admin")
				.accept(MediaType.APPLICATION_JSON_VALUE).content(content).contentType(MediaType.APPLICATION_JSON_VALUE);
		
		ResultActions result =  mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());	

	}
	
	
	@Test //test primary deposit 
	public void eTestPrimaryDeposit() throws Exception{
		mockMvc.perform(get("/deposit/{accType}/{accNo}/{amount}","Primary", 22113346,5000L))
		.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
		
	}
	
	
	@Test //test savings deposit
	public void fTestSavingsDeposit() throws Exception{
		mockMvc.perform(get("/deposit/{accType}/{accNo}/{amount}","Savings", 11223345,5000L))
		.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	}
	
	
	@Test //test create cheque request
	public void gTestCreateCheque() throws Exception {
		String content="{\r\n" + 
				"    \"id\":1,\r\n" + 
				"     \"fullname\":\"test\",\r\n" + 
				"    \"surname\":\"t\",\r\n" + 
				"    \"mailid\":\"test@gmail.com\",\r\n" + 
				"    \"phonenumber\":9876543210,\r\n" + 
				"    \"address\":\"chennai\",\r\n" + 
				"    \"password\":\"test1234\"\r\n" + 
				"}";
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/createcheque")
				.accept(MediaType.APPLICATION_JSON_VALUE).content(content).contentType(MediaType.APPLICATION_JSON_VALUE);
		
		ResultActions result =  mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
	}
	
	
	@Test //test get all cheque request
	public void hTestGetAllCheques() throws Exception{
		mockMvc.perform(get("/allcheques")).andExpect(status().isOk()).andDo(print());
	}
	
	
	@Test //withdraw from primary account
	public void iTestPrimaryWithdraw() throws Exception{
		mockMvc.perform(get("http://localhost:8090/withdraw/Primary/22113346/500")).andExpect(status().isOk()).andDo(print());
	}
	
	@Test //withdraw from savings account
	public void jTestSavingsWithdraw() throws Exception{
		mockMvc.perform(get("/withdraw/{accType}/{accNo}/{amount}","Savings", 11223345,5000L))
		.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
		}

	
	@Test //test transfer amount 
	public void kTestTransfer() throws Exception{
		
		String content="{\r\n" + 
				"    \"transactionAmount\":2000,\r\n" + 
				"    \"sourceAccountnumber\":\"22113345\",\r\n" + 
				"    \"destinationAccountnumber\":\"22113346\",\r\n" + 
				"    \"IFSC\":\"abc1234\"\r\n" + 
				"}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/transfer")
				.accept(MediaType.APPLICATION_JSON_VALUE).content(content).contentType(MediaType.APPLICATION_JSON_VALUE);
		ResultActions result =  mockMvc.perform(requestBuilder).andExpect(status().isOk()).andDo(print());
		
	}
	
	@Test //test getAllAccounts
	public void lGetAccounts() throws Exception{
		mockMvc.perform(get("/accounts")).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	}
	
	@Test //test getAllTransactions
	public void mGetAccountTransaction() throws Exception{
		mockMvc.perform(get("/accounts/{accountId}/transactions",22113345)).andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
	}
	
	
	
	
	

}
