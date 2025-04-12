package com.rickey;

import com.rickey.server.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @Description: A simple Thrift server implementation using TSimpleServer(BIO).
 * @Author: rickey-c
 * @Date: 2025/4/9 17:20
 */
@Slf4j
public class SimpleService {
    public static void main(String[] args) throws TTransportException {
        TServerSocket serverSocket = new TServerSocket(9090);
        UserService.Processor<UserServiceImpl> processor = new UserService.Processor<>(new UserServiceImpl());
        TBinaryProtocol.Factory protocolFactory = new TBinaryProtocol.Factory();
        TServer.Args targs = new TServer.Args(serverSocket);
        targs.processor(processor);
        targs.protocolFactory(protocolFactory);
        TSimpleServer server = new TSimpleServer(targs);
        log.info("Starting the simple server...");
        server.serve();
    }
}
