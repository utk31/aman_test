/*
 * Copyright (C) 2017 by Teradata Corporation.
 * All Rights Reserved.
 * TERADATA CORPORATION CONFIDENTIAL AND TRADE SECRET
 */
package com.mykong.test.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Utkarsh Thusoo
 * @version $Id: $
 */
public class DBManager
{
    public static Connection con;
    
    static{
        try
        {
            Class.forName("org.postgresql.Driver");

            // step2 create the connection object
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test",
                    "postgres", "password");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public static Connection getConnection()
    {
        return con;
    }
    
    public static void closeCon(){
        try{
            con.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    
}
