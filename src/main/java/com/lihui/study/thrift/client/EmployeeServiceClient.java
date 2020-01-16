package com.lihui.study.thrift.client;

import com.lihui.study.pb.EmployeePb;
import com.lihui.study.service.EmployeeService;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: EmployeeServiceClient
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2020-1-14  17:23
 */

public class EmployeeServiceClient {
    public void startClient(String username){
        System.out.println("服务启动："+username);
        try (TTransport tTransport = new TSocket("localhost",8888,30000)){
            // 协议要和服务端一致
            TProtocol protocol = new TBinaryProtocol(tTransport);
//            TProtocol protocol = new TCompactProtocol(tTransport);
//            TProtocol protocol = new TJSONProtocol(tTransport);
            EmployeeService.Client client = new EmployeeService.Client(protocol);
            tTransport.open();
            List<String> list=new ArrayList<>();
            list.add("11");
            list.add("22");
            for (int i=0;i<20;i++){
                List<EmployeePb> empByEmps = client.getEmpByEmpIds(list);
                for (EmployeePb employeePb:empByEmps){
                    System.out.println("Thrify client result = " + employeePb.toString());
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args){
        EmployeeServiceClient client = new EmployeeServiceClient();
        client.startClient(" world");
    }
}
