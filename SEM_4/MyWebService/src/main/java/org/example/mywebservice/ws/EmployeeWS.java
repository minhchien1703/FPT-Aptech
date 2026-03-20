package org.example.mywebservice.ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.example.mywebservice.dao.EmployeeDAO;
import org.example.mywebservice.model.Employee;
import org.example.mywebservice.dao.dto.*;

import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "EmployeeWS")
public class EmployeeWS {
    private EmployeeDAO dao = new EmployeeDAO();

    @WebMethod(operationName = "getEmployees")
    public List<res> getEmployees() {
        return dao.getAllEmployees();
    }

    @WebMethod(operationName = "addEmployees")
    public String addEmployees(@WebParam(name = "employee") req e) {
        boolean isSuccess = dao.addEmployee(e);
        if (isSuccess) {
            return "Thêm thành công nhân viên: " + e.getName();
        } else {
            return "Thêm thất bại! Vui lòng kiểm tra lại ID hoặc lỗi hệ thống.";
        }
    }

    @WebMethod(operationName = "updateEmployee")
    public String updateEmployee(@WebParam(name = "employee") req e) {
        boolean isSuccess = dao.updateEmployee(e);
        if (isSuccess) {
            return "Cập nhật thành công cho ID: " + e.getId();
        } else {
            return "Cập nhật thất bại! Không tìm thấy ID " + e.getId();
        }
    }
}
