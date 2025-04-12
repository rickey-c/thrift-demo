package com.rickey;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * @Description:
 * @Author: rickey-c
 * @Date: 2025/4/9 17:04
 */
@Slf4j
public class SimpleClient {
    public static void main(String[] args) throws TException {
        TTransport transport  = null;
        transport = new TSocket("localhost",9090);
        TBinaryProtocol protocol = new TBinaryProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);
        transport.open();
        User user = client.getById(1);
        log.info("user = "+ user);
        
    }
}
