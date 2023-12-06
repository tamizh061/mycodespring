package details.Techcorp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class CONTROLERCLASS {
    @Autowired
    SERVICECLASS serv;
    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/create")
    public String makecreate(@RequestBody ENTITYCLASS val) {
        String temp=encoder.encode(val.getPassword());
        val.setEmpPASS(temp);
        return serv.create(val).getEmpNAME()+ "has been added successfully";
    }
    @GetMapping("/list")
    public List<ENTITYCLASS> listal( ) {
        return serv.listall();
    }

    @PutMapping("/update")
    public String update( @RequestBody ENTITYCLASS emp){
        return serv.create(emp).getEmpNAME()+" has been updated";
    }
    @DeleteMapping("/remove/{id}")
    public String remove(@PathVariable("id") int id){

        return serv.removing(id).getEmpNAME()+"has been deleted";
    }
    @GetMapping("listone/{id}")
    public Optional<ENTITYCLASS> readone(@PathVariable int id ){
        return  serv.readone(id);
    }

    @GetMapping("listempname/{name}")
    public ENTITYCLASS readname(@PathVariable("name") String name){
        return  serv.viewname(name);
    }

    @GetMapping("lessthanval/{value}")
    public List<ENTITYCLASS> lessthanval(@PathVariable("value") int value)
    {
       return serv.firsstids(value);
    }
}