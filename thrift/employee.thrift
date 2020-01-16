namespace java com.lilhui.thrift.service

service EmployeeService{
    list<EmployeePb> getEmpByEmpIds(1:list<string> employeeIds);
    EmployeePb getEmpByEmpId(1:string employeeId,2:string employeeCode);
    void saveEmployee(1:EmployeePb employeePb);

}
struct EmployeePb{
1: required i32 id;
2: required string employeeCode;
3: required string employeeId;
4: optional string remark;
}