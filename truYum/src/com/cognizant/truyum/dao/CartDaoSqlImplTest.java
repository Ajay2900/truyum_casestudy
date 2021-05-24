package com.cognizant.truyum.dao;

import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static CartDao cartDao = new CartDaoSqlImpl();
	public static void testAddCartItem()
	{
		//CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem((long)1, (long) 1);
		cartDao.addCartItem((long)1, (long) 3);
		cartDao.addCartItem((long)1, (long) 4);
		try
		{
			ArrayList<MenuItem> cartList = cartDao.getAllCartItems((long)1);
			System.out.println("items added to cart successfuly");
			

			for (MenuItem item : cartList) {

				System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));

			}
			
		}
		catch(CartEmptyException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void testGetAllCartItems()
	{
		//CartDao cartDao = new CartDaoSqlImpl();
		try
		{
		 ArrayList<MenuItem> cartItems = cartDao.getAllCartItems((long)1);
		
		 for(MenuItem item:cartItems)
		 {
			 System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));
		 }
		}
		catch(CartEmptyException e)
		{
			e.printStackTrace();
		}
		
	}
	public static void testRemoveCartItem() 
	{
		//CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem((long)1,(long)3);
		try
		{
			ArrayList<MenuItem> cartLefts = cartDao.getAllCartItems((long)1); 
			if(cartLefts.isEmpty())
			{
				throw new CartEmptyException();
			}
			else
			{
				for(MenuItem item:cartLefts)
				{
					System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",item.getName(),item.getPrice(),item.isActive(),item.getDateOfLaunch(),item.getCategory(),item.isFreeDelivery()));
				}
			}
		}
		catch(CartEmptyException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		testAddCartItem();
		testGetAllCartItems();
		testRemoveCartItem();
		
	}
}
