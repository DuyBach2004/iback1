package vn.iback.studentmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.iback.studentmanager.dao.RoleRespository;
import vn.iback.studentmanager.entity.*;
import vn.iback.studentmanager.service.Userservice;
import vn.iback.studentmanager.service.khoaService.khoaService;
import vn.iback.studentmanager.service.lopSevice.lopService;
import vn.iback.studentmanager.service.studentService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private Userservice userservice;
    private vn.iback.studentmanager.service.studentService studentService;
    private khoaService khoaService;
    private lopService lopService;
    private RoleRespository roleRespository;
    @Autowired
    public UserController(Userservice userservice, vn.iback.studentmanager.service.studentService studentService, vn.iback.studentmanager.service.khoaService.khoaService khoaService, vn.iback.studentmanager.service.lopSevice.lopService lopService, RoleRespository roleRespository) {
        this.userservice = userservice;
        this.studentService = studentService;
        this.khoaService = khoaService;
        this.lopService = lopService;
        this.roleRespository = roleRespository;
    }

    @GetMapping("/update")
    public String updateStudent(@RequestParam("username") String username, Model model){
        user user=userservice.findByUsername(username);
        student student=studentService.findStudentById(user.getStudentId().getStudentId());
        model.addAttribute("student",student);
        return "user/update";
    }
    @PostMapping("/update-if")
    public String updateInfor(@ModelAttribute("user") user user, Model model){
        userservice.update(user);
        return "redirect:/user/showListUser";
    }
    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") String username, Model model){
        userservice.deleteByUsername(username);
        return "redirect:homeUser";
    }
    @GetMapping("/showListUser")
    public String showListUser(Model model){
        List<user> userList=userservice.findAll();
        model.addAttribute("userList",userList);
        return "user/home";
    }
    @GetMapping("/showPageIfUser")
    public String showListUser(@RequestParam("username") String username,Model model){
        user user=userservice.findByUsername(username);

        model.addAttribute("user",user);
        return "user/showInformation";
    }

    @PostMapping("/update-khoa")
    public String updateKhoa(@ModelAttribute("user") user user , @RequestParam("id") String maKhoa, Model model){
        khoa khoa=khoaService.findkyHocid(maKhoa);
        user.setKhoa(khoa);
        userservice.update(user);
        return "redirect:/user/showListUser";
    }

    @GetMapping("/updateRole")
    public String updateRole(@RequestParam("username") String username ,@RequestParam("id") int id, Model model){
        //        roles defautRole=roleRepository.findByName("ROLE_USER");
//        Collection<roles> roles=new ArrayList<>();
//        roles.add(defautRole);
//        user.setRoles(roles);
//        userservice.save(user);
        user user=userservice.findByUsername(username);
        if(id==1){
            roles defautRole=roleRespository.findByName("ROLE_ADMIN");
            Collection<roles> roles=new ArrayList<>();
            roles.add(defautRole);
            user.setRoles(roles);
            userservice.update(user);
        } else if (id==2) {
            roles defautRole=roleRespository.findByName("ROLE_MANAGER");
            Collection<roles> roles=new ArrayList<>();
            roles.add(defautRole);
            user.setRoles(roles);
            userservice.update(user);
        }else if (id==3) {
            roles defautRole=roleRespository.findByName("ROLE_TEACHER");
            Collection<roles> roles=new ArrayList<>();
            roles.add(defautRole);
            user.setRoles(roles);
            userservice.update(user);
        }else if (id==4) {
            roles defautRole=roleRespository.findByName("ROLE_USER");
            Collection<roles> roles=new ArrayList<>();
            roles.add(defautRole);
            user.setRoles(roles);
            userservice.update(user);
        }

        return "redirect:/user/showListUser";
    }
    @PostMapping("/update-lop")
    public String updateLop(@ModelAttribute("user") user user , @RequestParam("id") String maLop, Model model){
        lop lop=lopService.findLopById(maLop);
        user.setLop(lop);
        userservice.update(user);
        return "redirect:/user/showListUser";
    }

}
