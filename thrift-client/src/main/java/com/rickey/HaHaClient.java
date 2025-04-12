package com.rickey;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

/**
 * @Description:
 * @Author: rickey-c
 * @Date: 2025/4/12 20:16
 */
public class HaHaClient {
    public static void main(String[] args) throws TException {
        TTransport transport = new TFramedTransport(new TSocket("localhost",9090));
        // 协议要和服务端一致
        TProtocol protocol = new TBinaryProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);
        transport.open();

        String result = String.valueOf(client.getById(1));
        System.out.println("Result =: " + result);
        transport.close();
    }
}
