package vn.iback.studentmanager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.iback.studentmanager.entity.lichHoc;
import vn.iback.studentmanager.service.lichHocService.lichHocService;

import java.util.List;

@Controller
@RequestMapping("lich-hoc")
public class LichHocController {
    private lichHocService lichHocService;
    @Autowired
    public LichHocController(vn.iback.studentmanager.service.lichHocService.lichHocService lichHocService) {
        this.lichHocService = lichHocService;
    }
    @GetMapping("/delete")
    public String deleteLichHoc(@RequestParam("id") int id, Model model){
        lichHocService.deleteById(id);
        return "redirect:/lich-hoc/showPageLichHoc";
    }
    @GetMapping("/showPageLichHoc")
    public String showPageLichHoc(Model model){
        List<lichHoc> lichHocList=lichHocService.findAllLichHoc();
        model.addAttribute("lichHocList",lichHocList);
        return "lichhoc/home";
    }
    @GetMapping("/showPageLichHocUser")
    public String showPageLichHocUser(Model model){
        List<lichHoc> lichHocList=lichHocService.findAllLichHoc();
        model.addAttribute("lichHocList",lichHocList);
        return "lichhoc/showLichHocUser";
    }


}
