/*
 * Copyright (C) 2017 by Teradata Corporation.
 * All Rights Reserved.
 * TERADATA CORPORATION CONFIDENTIAL AND TRADE SECRET
 */
package com.mykong.test.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mkyong.rest.Layer;
import com.mkyong.rest.Pole;

/**
 * @author Utkarsh Thusoo
 * @version $Id: $
 */
public class DBConnection
{

    public static List<String> getConnection()
    {
        List<String> output = new ArrayList<>();
        try
        {
            Class.forName("org.postgresql.Driver");

            // step2 create the connection object
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test",
                    "postgres", "password");

            // step3 create the statement object
            Statement stmt = con.createStatement();
            Layer l = getLayer(stmt);
            List<String> p = getPoles(stmt, l.getColname(), l.getColdata());

            String[] texts = l.getColtext().split(",");
            for (int i = 0; i < 4; i++)
            {
                output.add(texts[i] + ":" + p.get(i));
            }
            con.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

        return output;
    }

    private static Layer getLayer(Statement stmt) throws SQLException
    {
        ResultSet rs = stmt.executeQuery("select * from layer");
        Layer l = null;
        while (rs.next())
        {
            String a = rs.getString(1);
            String b = rs.getString(2);
            String c = rs.getString(3);
            String d = rs.getString(4);

            l = new Layer(a, b, c, d);
            System.out.println("Layer DB: " + a + "  " + b + "  " + c + " " + d);
        }

        return l;
    }

    private static List<String> getPoles(Statement stmt, String table, String columns)
            throws SQLException
    {
        ResultSet rs = stmt.executeQuery("select " + columns + " from " + table);
        List<String> values = new ArrayList<>();
        while (rs.next())
        {

            values.add(rs.getString(1));
            values.add(rs.getString(2));
            values.add(rs.getString(3));
            values.add(rs.getString(4));

        }
        return values;
    }
}
