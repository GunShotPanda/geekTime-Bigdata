package com.geektime.homework3;
import org.apache.hadoop.hbase.NamespaceDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/**
 * @author peiran.li@tendcloud.com
 * @description TODO
 * @date 2021/7/28 11:37 下午
 */

public class HbaseDemo {
  public static void main(String[] args) throws Exception {
    Admin admin = HbaseUtil.getAdmin();
        HbaseUtil.showTable();
    String nameSpace = "lpr";
    String[] fields = {"name","info","score"};
    String tbName = "lpr:student";
    String rowKey = "1";
    admin.createNamespace(NamespaceDescriptor.create(nameSpace).build());
    System.out.println("建表：");
    HbaseUtil.creatTable(tbName, fields);

    System.out.println("put data：");
    String[] subColums = {"name","info:student_id","info:class","score:understanding","score:programming"};
    HbaseUtil.addRecord(tbName,rowKey,subColums,new String[]{"lpr","G20200343040192","1","90","90"});

    System.out.println("列表：");
    HbaseUtil.showTable();

    System.out.println("扫描表："+tbName);
    HbaseUtil.scanTable(tbName);


  }
}