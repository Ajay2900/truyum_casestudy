package com.cognizant.truyum.dao;


import java.text.SimpleDateFormat;
import java.util.*;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	
	public static void testGetMenuItemListAdmin()
	{
		
		MenuItemDaoSqlImpl menuItemDao = null;
		try {
			menuItemDao = new MenuItemDaoSqlImpl();
			ArrayList<MenuItem> menuItems = new ArrayList <MenuItem>();
			menuItems = menuItemDao.getMenuItemListAdmin();
	        System.out.println("Menu item list for admin"); 
	        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/YYYY");
	        System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));   
			for (MenuItem items : menuItems) {
				System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",items.getName(),items.getPrice(),items.isActive(),simple.format(items.getDateOfLaunch()),items.getCategory(),items.isFreeDelivery()));

			}	
		} 
		catch (Exception e) 
		{
		
			e.printStackTrace();
		}
		
	}
	public static void testGetMenuItemListCustomer()
	{
		
		MenuItemDaoSqlImpl menuItemDao = null;

		try {

			menuItemDao = new MenuItemDaoSqlImpl();

			ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();

			menuItems = menuItemDao.getMenuItemListCustomer();

			System.out.println("Menu item list for customer"); 
			SimpleDateFormat simple = new SimpleDateFormat("dd/MM/YYYY");

			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery"));

			for (MenuItem items : menuItems) {

				System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",items.getName(),items.getPrice(),items.isActive(),simple.format(items.getDateOfLaunch()),items.getCategory(),items.isFreeDelivery()));


			}

		} 
		catch (Exception e) 
		{

		  e.printStackTrace();

		}
	}
	public static void testmodifyMenuItem()
	{
		try {

			MenuItem menuItem = new MenuItem((long) 01,"keyboard", "Dessert",(float)150.0, true,true,DateUtil.convertToDate("02/11/2022"));

			MenuItemDaoSqlImpl menuItemDao = new MenuItemDaoSqlImpl();

			menuItemDao.modifyMenuItem(menuItem);
			
			SimpleDateFormat simple = new SimpleDateFormat("dd/MM/YYYY");

			MenuItem modified_item = menuItemDao.getMenuItem(menuItem.getId());

			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n","Name","Price","Active","Date Of Launch","Category","Free Delivery")); 

			System.out.println(String.format("%-25s%-25s%-25s%-25s%-25s%-20s\n",modified_item.getName(),modified_item.getPrice(),modified_item.isActive(),simple.format(modified_item.getDateOfLaunch()),modified_item.getCategory(),modified_item.isFreeDelivery()));


			System.out.println("Modification Done");

		} 
		catch (Exception e)
		{

         e.printStackTrace();

		}
	}
	public static void main(String[] args) 
	{
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
        testmodifyMenuItem();
		
		
	}
	

}
