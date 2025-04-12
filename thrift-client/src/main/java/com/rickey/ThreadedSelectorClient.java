package com.rickey;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.layered.TFramedTransport;

/**
 * @Description:
 * @Author: rickey-c
 * @Date: 2025/4/12 21:05
 */
public class ThreadedSelectorClient {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread("Thread " + i) {
                @Override
                public void run() {
                    // 设置传输通道 对于非阻塞服务 需要使用TFramedTransport(用于将数据分块发送)
                    for (int j = 0; j < 10; j++) {
                        try (TTransport transport = new TFramedTransport(new TSocket("localhost", 9090))) {
                            TProtocol protocol = new TBinaryProtocol(transport);
                            UserService.Client client = new UserService.Client(protocol);
                            transport.open();
                            String result = String.valueOf(client.getById(1));
                            System.out.println("Result =: " + result);
                            transport.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        // 关闭传输通道
                    }
                }
            }.start();
        }
    }
}
