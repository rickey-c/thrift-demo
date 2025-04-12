package com.rickey;

import com.rickey.server.UserServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.TNonblockingServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

/**
 * @Description:
 * @Author: rickey-c
 * @Date: 2025/4/11 11:13
 */
public class NonblockingServer {
    public static void main(String[] args) throws TTransportException {
        TProcessor tprocessor = new UserService.Processor<UserService.Iface>(new UserServiceImpl());
        TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(9090);
        TNonblockingServer.Args tnbArgs = new TNonblockingServer.Args(tnbSocketTransport);
        tnbArgs.processor(tprocessor);
        tnbArgs.transportFactory(new TFramedTransport.Factory());
        tnbArgs.protocolFactory(new TCompactProtocol.Factory());

        // 使用非阻塞式IO服务端和客户端需要指定TFramedTransport数据传输的方式
        TServer server = new TNonblockingServer(tnbArgs);
        System.out.println("Running Non-blocking Server");
        server.serve();
    }
}
