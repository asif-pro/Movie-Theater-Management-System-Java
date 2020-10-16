package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class CustomerRepo implements ICustomerRepo
{
	DatabaseConnection dbc;
		
	public CustomerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	
	public void insertCustomer(Customer c)
	{
		String query = "INSERT INTO customer VALUES ('"+c.getCustomerId()+"','"+c.getCustomerName()+"','"+c.getPhone()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updateCustomer(Customer c)
	{
		String query = "UPDATE customer SET customerName='"+c.getCustomerName()+"', phone = '"+c.getPhone()+"' WHERE CustomerId='"+c.getCustomerId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
}	