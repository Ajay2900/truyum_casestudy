package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;



public class CartDaoSqlImpl  implements CartDao{
	
	
	@Override
	public void addCartItem(long userId, long menuItemId) {
	{
		Connection con = ConnectionHandler.getConnection();
		String Query = "insert into cart(user_id,item_id)"+"values (?,?) ";
		try 
		{
			PreparedStatement stmt = con.prepareStatement(Query);
			stmt.setLong(1, userId);
			stmt.setLong(2, menuItemId);
			stmt.execute();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	}
	public ArrayList<MenuItem> getAllCartItems(long userId) {
		
		Connection con = ConnectionHandler.getConnection();
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		
		Cart cart = new Cart(0,menuItemList);
		String query = "select * from menu_items JOIN cart ON menu_items.item_id = cart.item_id where cart.user_id = ?";
		float value  = 0.00f;
		try
		{
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1, userId);
			ResultSet rs = stmt.executeQuery();			
			while(rs.next())
			{
				long id = rs.getLong("item_id");
				String name  = rs.getString("item_name");
				float price = rs.getFloat("price");
				value = value + price;
				String active = rs.getString("active");
				Date date1 = rs.getDate("date_of_launch");
				String category = rs.getString("category");
				String free_delivery = rs.getString("free_delivery");
				boolean act = false;
				if(active.equalsIgnoreCase("yes"))
				{
					act = true;
				}
				boolean free=false;
				if(free_delivery.equalsIgnoreCase("yes"))
				{
					free = true;
				}
				MenuItem m1  = new MenuItem(id,name,category,price,act,free,date1);
				menuItemList.add(m1);
				
			}
			cart.setTotal(value);
			cart.setMenuItemList(menuItemList);	
		} 
		catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		
		return menuItemList;
	}
	
	public double getTotal() {
		
	  Cart c = new Cart();
	  return c.getTotal();

	}
	
	public void removeCartItem(long userId, long menuItemId)
	{
		Connection con = ConnectionHandler.getConnection();
		String query = "delete from  cart where user_id = ? AND item_id = ?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setLong(1,userId);
			stmt.setLong(2, menuItemId);
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	
}
