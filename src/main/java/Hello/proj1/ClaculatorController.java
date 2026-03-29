package Hello.proj1;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/calc")
public class ClaculatorController {
    @GetMapping
    Map<String,Object> getResult(@RequestParam("num1") double a,@RequestParam("num2") double b,@RequestParam("Op")String op){
        double result = 0;
        Map<String,Object>mp = new LinkedHashMap<>();
        switch (op){
            case "add": {
                result = a + b;
                break;
            }
            case "sub":{
                result = a-b;
                break;
            }
            case "mul":{
                result = a*b;
                break;
            }
            case "div":{
                if(b == 0){
                    mp.put("Error","Cannot divde by Zero");
                    break;
                }
                else{
                    result = a/b;
                    break;
                }
            }
            default:{
                mp.put("Error","Invalid operation");
                return mp;
            }
        }
        mp.put("num1",a);
        mp.put("num2",b);
        mp.put("result",result);
        mp.put("operation",op);
        return mp;
    }
}
