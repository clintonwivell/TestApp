package main.com.gap;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DohlcDAOTest {

	DohlcDAO dao;
	
	public DohlcDAOTest(){
		dao = new DohlcDAO();
	}
	
	@Test
	public void testListAll() {
		int count = 0;
		List <DOHLC> dohclList = dao.listAll();
		for (DOHLC dohlc : dohclList)
		{
			System.out.println(dohlc);
			count++;
		}
		
		System.out.println("\n\ncount = " + count);
		
		assert(count == 4073);
	}

}
