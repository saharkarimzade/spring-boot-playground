

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class PassedStudent {

    @RequestMapping("/")
    public String index() {
        return "First passed Test!";
    }

}
