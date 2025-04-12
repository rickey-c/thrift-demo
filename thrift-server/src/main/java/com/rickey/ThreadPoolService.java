package com.rickey;

import com.rickey.server.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @Description:
 * @Author: rickey-c
 * @Date: 2025/4/11 10:39
 */
@Slf4j
public class ThreadPoolService {
    public static void main(String[] args) throws TTransportException {
        TServerSocket socket = new TServerSocket(9090);
        UserService.Processor<UserServiceImpl> processor = new UserService.Processor<>(new UserServiceImpl());
        TBinaryProtocol.Factory factory = new TBinaryProtocol.Factory();
        TThreadPoolServer.Args ttpsArgs = new TThreadPoolServer.Args(socket);
        ttpsArgs.processor(processor);
        ttpsArgs.protocolFactory(factory);

        TThreadPoolServer ttpsServer = new TThreadPoolServer(ttpsArgs);
        log.info("Running ThreadPoolService ...");
        ttpsServer.serve();
    }
}
