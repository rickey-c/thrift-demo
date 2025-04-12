package com.rickey;

import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TConfiguration;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.layered.TFramedTransport;

/**
 * @Description:
 * @Author: rickey-c
 * @Date: 2025/4/11 11:15
 */
@Slf4j
public class NonblockingClient {
    public static void main(String[] args) throws TException {
        TTransport transport = new TFramedTransport(new TSocket(new TConfiguration(), "localhost", 9090));
        // 协议要和服务端一致
        TProtocol protocol = new TCompactProtocol(transport);
        UserService.Client client = new UserService.Client(protocol);
        transport.open();
        User user = client.getById(100);
        log.info("user = " + user);
        transport.close();
    }
}
