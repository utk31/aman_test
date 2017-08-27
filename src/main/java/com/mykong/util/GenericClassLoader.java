package com.mykong.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mkyong.rest.Layer;

public class GenericClassLoader
{

    public static List<Layer> getLayers(Connection con)
            throws SQLException
    {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from layer");
        
        List<Layer> layer = new ArrayList<>();
        while (rs.next())
        {
            String a = rs.getString(1);
            String b = rs.getString(2);
            String c = rs.getString(3);
            String d = rs.getString(4);

            layer.add(new Layer(a, b, c, d));
            System.out.println("Layer DB: " + a + "  " + b + "  " + c + " " + d);
        }

        return layer;
    }
    
    public static List<List<String>> getTblData(Connection con, String table, String columns, String pid)
            throws SQLException
    {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select " + columns + " from " + table + " where pid = '"+ pid +"'");
        List<List<String>> result = new ArrayList<>();
        
        while (rs.next())
        {
            List<String> values = new ArrayList<>();
            values.add(rs.getString(1));
            values.add(rs.getString(2));
            values.add(rs.getString(3));
            values.add(rs.getString(4));
            result.add(values);
        }
        return result;
    }
}
