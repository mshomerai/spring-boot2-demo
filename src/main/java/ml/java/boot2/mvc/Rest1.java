package ml.java.boot2.mvc;

import org.apache.commons.io.FileUtils;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mapping")
public class Rest1 {

    //@PathVariable Map<String,String> pv：全路径参数集合，一定是Map<String,String>。
    @GetMapping("/1/car/{id}/owner/{name}")
    Map<String, Object> mapping1(@PathVariable("id") Integer id, @PathVariable("name") String name, @PathVariable Map<String,String> pv) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("name", name);
        map.put("pv", pv);
        return map;
    }

    @GetMapping("/2")
    Map<String, Object> mapping2(@RequestHeader("Host") String host, @RequestHeader Map<String,String> rh){
        Map<String, Object> map = new HashMap<>();
        map.put("host", host);
        map.put("rh", rh);
        return map;
    }

    //List：?age=20&hobbies=model&hobbies=game
    @GetMapping("/3")
    Map<String, Object> mapping3(@RequestParam("age") Integer age, @RequestParam("hobbies") List<String> hobbies, @RequestParam Map<String,String> rp){
        Map<String, Object> map = new HashMap<>();
        map.put("age", age);
        map.put("hobbies", hobbies);
        map.put("rp", rp); //因为<String,String> 所以不能支持List
        return map;
    }

    //请求时在Header中增加Cookie字段来设置Cookie
    @GetMapping("/4")
    Map<String, Object> mapping4(@CookieValue("_ga") String _ga, @CookieValue("_gb") Cookie cookieGb){
        System.out.println(cookieGb.getName() + " " + cookieGb.getValue());
        Map<String, Object> map = new HashMap<>();
        map.put("_ga", _ga);
        return map;
    }

    //当使用form提交时@RequestBody：{"content": "age=10&name=m"}
    @PostMapping("/5")
    Map<String, Object> mapping5(@RequestBody String content){
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

    @GetMapping("/6o")
    Map mapping6o(@RequestAttribute("msg")String msg, HttpServletRequest httpServletRequest){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("code", httpServletRequest.getAttribute("code"));
        return map;
    }

    @GetMapping("/8")
    ResponseEntity<byte[]> mapping8(HttpServletRequest request) throws IOException {
        String filename = "sys-info.log";
        File file = new File("C:/home/ruoyi/logs/" + filename);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }

}
