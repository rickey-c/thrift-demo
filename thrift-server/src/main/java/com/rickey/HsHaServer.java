package com.rickey;

import com.rickey.server.UserServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;

/**
 * @Description:
 * @Author: rickey-c
 * @Date: 2025/4/9 14:00
 */
public class HsHaServer {
    public static void main(String[] args) throws TTransportException {
        TNonblockingServerSocket tnbSocketTransport = new TNonblockingServerSocket(9090);
        TProcessor tprocessor = new UserService.Processor<UserService.Iface>(new UserServiceImpl());
        // 半同步半异步
        THsHaServer.Args thhsArgs = new THsHaServer.Args(tnbSocketTransport);
        thhsArgs.processor(tprocessor);
        thhsArgs.transportFactory(new TFramedTransport.Factory());
        thhsArgs.protocolFactory(new TBinaryProtocol.Factory());

        TServer server = new THsHaServer(thhsArgs);
        System.out.println("Running HsHa Server");
        server.serve();
    }
}
