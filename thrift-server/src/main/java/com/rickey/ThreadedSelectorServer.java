package com.rickey;

import com.rickey.server.UserServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

/**
 * @Description:
 * @Author: rickey-c
 * @Date: 2025/4/12 21:02
 */
public class ThreadedSelectorServer {
    public static void main(String[] args) throws TTransportException {
        TNonblockingServerSocket serverSocket = new TNonblockingServerSocket(9090);
        TProcessor processor = new UserService.Processor<UserService.Iface>(new UserServiceImpl());
        // 多线程半同步半异步
        TThreadedSelectorServer.Args ttssArgs = new TThreadedSelectorServer.Args(serverSocket);
        ttssArgs.processor(processor);
        ttssArgs.protocolFactory(new TBinaryProtocol.Factory());
        // 使用非阻塞式IO时 服务端和客户端都需要指定数据传输方式为TFramedTransport
        ttssArgs.transportFactory(new TFramedTransport.Factory());

        // 多线程半同步半异步的服务模型
        TThreadedSelectorServer server = new TThreadedSelectorServer(ttssArgs);
        System.out.println("Running ThreadedSelector Server");
        server.serve();
    }
}
