package com.geektime.homework2;

import java.io.IOException;
import java.net.InetSocketAddress;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

/**
 * @author peiran.li@tendcloud.com
 * @description TODO
 * @date 2021/7/27 11:33 上午
 */

public class RpcClient
{

  public static void main(String[] args) throws IOException {
    //获取服务端代理
    IProxyProtocol client = RPC
        .getProxy(IProxyProtocol.class, IProxyProtocol.versionID, new InetSocketAddress("localhost", 8888), new Configuration());
    System.out.println("------------------- client start");
    //调用服务端的创建方法。
    String studentId = "G20200343040192";
    String name = client.findName(studentId);
    System.out.format("-----student:%-20s----------name:%-5s",studentId,name);

  }

}