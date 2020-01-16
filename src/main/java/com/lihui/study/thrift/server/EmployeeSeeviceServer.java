package com.lihui.study.thrift.server;

import com.lihui.study.service.EmployeeService;
import com.lihui.study.service.impl.EmployeeServiceImpl;
import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TSimpleServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

/**
 * @ClassName: EmployeeSeeviceServer
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2020-1-14  17:19
 */

public class EmployeeSeeviceServer {
    public void startServer(){
        try {
            System.out.println("EmployeeServer start ... ");
            TServerSocket serverTransport = new TServerSocket(8888);
            TServer.Args tArgs = new TServer.Args(serverTransport);
            TProcessor tProcessor = new EmployeeService.Processor<EmployeeService.Iface>(new EmployeeServiceImpl());
            tArgs.processor(tProcessor);
            tArgs.protocolFactory(new TBinaryProtocol.Factory());
//            tArgs.protocolFactory(new TCompactProtocol.Factory());
//            tArgs.protocolFactory(new TJSONProtocol.Factory());
            TServer server = new TSimpleServer(tArgs);
            server.serve();
            System.out.println(1111);
        } catch (TTransportException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        EmployeeSeeviceServer serviceServer = new EmployeeSeeviceServer();
        serviceServer.startServer();
    }
}
