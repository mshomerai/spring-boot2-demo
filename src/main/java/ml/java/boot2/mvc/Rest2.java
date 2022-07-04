package ml.java.boot2.mvc;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class Rest2 {

    @GetMapping("/6i")
    String mapping6i(HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("msg", "hello");
        httpServletRequest.setAttribute("code", 200);
        return "forward:/mapping/6o";
    }

    @GetMapping("7")
    void mapping7(HttpServletResponse response) throws IOException {
        Resource res= new ClassPathResource("/pics/QR.jpg");
        response.setContentType("image/png");
        OutputStream stream = response.getOutputStream();
        stream.write(FileCopyUtils.copyToByteArray(res.getInputStream()));
        stream.flush();
        stream.close();
    }

}
