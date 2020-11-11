package com.test.srv.lis.controller;

        import com.test.srv.helper.ResponseMessage;
        import com.test.srv.lis.dto.StudentRegDTO;
        import com.test.srv.lis.dto.VillageRegistrationDTO;
        import com.test.srv.lis.service.VillageService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.ResponseBody;

        import javax.servlet.http.HttpServletRequest;
        import java.io.IOException;

@Controller
@RequestMapping("villageRegistration")
public class VillageRegistrationController {

    //INJECTION
    @Autowired
    private VillageService villageService;

    @RequestMapping(value = "" , method = RequestMethod.GET)
    public String index() {
        return "villageRegistration";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseMessage save(HttpServletRequest request, VillageRegistrationDTO villageRegistrationDTO) throws IOException {
//        CurrentUser currentUser = (CurrentUser) request.getSession().getAttribute("currentUser");
        return villageService.save(villageRegistrationDTO);
    }
}
