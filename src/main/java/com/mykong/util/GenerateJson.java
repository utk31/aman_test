/*
 * Copyright (C) 2017 by Teradata Corporation.
 * All Rights Reserved.
 * TERADATA CORPORATION CONFIDENTIAL AND TRADE SECRET
 */
package com.mykong.util;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mkyong.rest.Layer;
import com.mykong.test.dbcon.DBManager;

/**
 * @author Utkarsh Thusoo
 * @version $Id: $
 */
public class GenerateJson
{

    public static List<Map<String, String>> values(String pid) 
    {
        List<Map<String, String>> result = new ArrayList<>();
        try{
            Connection con = DBManager.getConnection();

            List<Layer> layers = GenericClassLoader.getLayers(con);
           
            for (Layer each : layers)
            {
                String tableName = each.getColname();
                String columnName = each.getColdata();
                String data = each.getColtext();
                initializeMap(pid,data,tableName,columnName,result);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
       
        
        return result;
    }

    private static void initializeMap(String pid, String data, String tableName, String columnName, List<Map<String, String>> result) throws Exception
    {   
        Connection con = DBManager.getConnection();
        List<List<String>> tblValues = GenericClassLoader.getTblData(con,tableName,columnName,pid);
        String[] text = data.split(",");
        int counter = 0;
        Map<String,String> map = null;
        
        for(List<String> each : tblValues){
            counter = 0;
            map = new HashMap<>();
            for(String val : each){
                map.put(text[counter++], val);
            }
            result.add(map);
        }
        
    }

}
