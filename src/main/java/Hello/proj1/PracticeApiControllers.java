package Hello.proj1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/practice")
public class PracticeApiControllers {
    @GetMapping("/greet")
    Map<Object,Object> greet(
            @RequestParam("name") String name
    ){
        Map<Object,Object> mp = new HashMap<>();
        mp.put("message","Hello "+name);
        return mp;
    }
    @GetMapping("/check")
    Map<Object,Object> checkEvenOrOdd(@RequestParam("num1") int n1){
        Map<Object,Object> mp = new LinkedHashMap<>();
        mp.put("number",n1);
        if(n1%2 == 0){
            mp.put("Number = "+n1 ,"Even");
            return mp;
        }
        mp.put("Number = "+n1,"Odd");
        return mp;
    }
    @GetMapping("/length")
    Map<Object,Object> checkLength(@RequestParam("text")String text){
        Map<Object,Object> mp = new HashMap<>();
        mp.put(text,"The text length  is = "+text.length());
        return mp;
    }
    @GetMapping("/reverse")
    Map<Object,Object> reverseString(@RequestParam("text")String text){
        Map<Object,Object> mp = new HashMap<>();
        String res = "";
        for(int i = text.length()-1;i>=0;i--){
            res += text.charAt(i);
        }
        mp.put(text,res);
        return mp;
    }
    @GetMapping("/UpperCase")
    Map<Object,Object> conevrtUpperCase(@RequestParam("text")String text){
        Map<Object,Object>mp = new HashMap<>();
        mp.put(text,text.toUpperCase());
        return mp;
    }
    @GetMapping("/Authentication")
    Map<Object,Object> login(@RequestParam("pass")long password){
        Map<Object,Object> mp = new HashMap<>();
        if(password == 123456){
            mp.put("login","sucees");
            return mp;
        }
        mp.put("login","failure");
        return mp;
    }
}
