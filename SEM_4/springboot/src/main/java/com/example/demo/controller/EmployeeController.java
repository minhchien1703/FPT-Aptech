package com.example.demo.controller;

import com.example.demo.dto.Employee.EmployeeRequestDto;
import com.example.demo.dto.Employee.EmployeeResponseDto;
import com.example.demo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String viewHomePage(Model model, @RequestParam(name = "keyword", required = false) String keyword) {
        List<EmployeeResponseDto> listEmployees = employeeService.getAllEmployees(keyword);

        model.addAttribute("listEmployees", listEmployees);
        model.addAttribute("keyword", keyword);

        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        EmployeeResponseDto employee = new EmployeeResponseDto();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@Valid @ModelAttribute("employee") EmployeeRequestDto requestDto,
                               BindingResult result,
                               RedirectAttributes redirectAttributes) {

        // Kiểm tra lỗi Validation (nếu tên rỗng, lương âm...)
        if (result.hasErrors()) {
            return "new_employee"; // Nếu lỗi, ở lại trang form để hiện thông báo đỏ
        }

        // Lưu vào DB
        employeeService.saveEmployee(requestDto);

        // Tạo thông báo thành công (hiện màu xanh như trong ảnh đề bài)
        redirectAttributes.addFlashAttribute("message", "User saved/updated successfully!");

        return "redirect:/"; // Quay về trang chủ
    }

    // 4. Hiển thị form cập nhật (Lấy dữ liệu cũ đổ vào form)
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
        // Lấy nhân viên từ Service
        EmployeeResponseDto employee = employeeService.getEmployeeById(id);

        // Đặt vào model để form hiển thị
        model.addAttribute("employee", employee);

        return "new_employee"; // Tái sử dụng file form của chức năng thêm mới
    }

    // 5. Xóa nhân viên
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") Long id, RedirectAttributes redirectAttributes) {

        this.employeeService.deleteEmployeeById(id);

        redirectAttributes.addFlashAttribute("message", "User deleted successfully!");
        return "redirect:/";
    }
}