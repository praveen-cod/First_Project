package Hello.proj1;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/todo")
public class ToDoController {
    @GetMapping("/Hi")
    String SayHiWithName(){
        return "Hi Praveen dude";
    }
    @GetMapping("/Hello")
    String SayHelloWithName(){
        return "Hello Praveen Dude";
    }
    @GetMapping("/{id}")
    String returnId(@PathVariable long id){
        return "Hi thi is path varible id"+id;
    }
    @GetMapping
    String reuquestParm(@RequestParam("a")double a ,@RequestParam("b") double b){
        double res = a+b;
        return "The result value is"+res;
    }
    @GetMapping("/mul")
    double mul(@RequestParam("a1") double a,@RequestParam("b1") double b){
        return a*b;
    }
}
