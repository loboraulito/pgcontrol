package bo.edu.uto.dtic.sim.controladores;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController {


  @RequestMapping("/error")
  public String error(HttpServletRequest request, Model model) {
    Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    if(status != null){
      Integer statusCode = Integer.valueOf(status.toString());
      model.addAttribute("statusCode", statusCode);
    }
    Object errorObject = request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
    if(errorObject != null){
      String error_exception = (request.getAttribute(RequestDispatcher.ERROR_EXCEPTION)).toString();
      model.addAttribute("error_exception", error_exception);
    }
    return "authentication/auth-500";
  }

  public String getErrorPath() {
    return "/error";
  }
}