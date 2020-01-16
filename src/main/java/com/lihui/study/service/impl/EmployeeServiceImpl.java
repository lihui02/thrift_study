package com.lihui.study.service.impl;

import com.lihui.study.pb.EmployeePb;
import com.lihui.study.service.EmployeeService;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName: EmployeeServiceImpl
 * @Description: TODO
 * @author: ex_lihui4
 * @date: 2020-1-7  15:06
 */

public class EmployeeServiceImpl implements EmployeeService.Iface {
    @Override
    public List<EmployeePb> getEmpByEmpIds(List<String> employeeIds) throws TException {
        List<EmployeePb> employeePbs=new ArrayList<>();
        int i=1;
        for (String employeeId:employeeIds ){
            EmployeePb employeePb=new EmployeePb();
            employeePb.setId(i++);
            employeePb.setEmployeeId(employeeId);
            employeePb.setEmployeeCode(UUID.randomUUID().toString());
            employeePb.setRemark("备注"+i);
            employeePbs.add(employeePb);
        }
        return employeePbs;
    }

    @Override
    public EmployeePb getEmpByEmpId(String employeeId, String employeeCode) throws TException {

        return null;
    }

    @Override
    public void saveEmployee(EmployeePb employeePb) throws TException {

    }
}
