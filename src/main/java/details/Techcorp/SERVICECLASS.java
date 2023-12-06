package details.Techcorp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SERVICECLASS  implements UserDetailsService {
    @Autowired
    REPOSITORYCLASS repo;

    public ENTITYCLASS create(ENTITYCLASS value){
        return repo.save(value);
    }
    public List<ENTITYCLASS> listall() {
        return repo.findAll();
    }

    public  ENTITYCLASS removing(int id) {
        ENTITYCLASS temp=repo.findById(id).orElse(new ENTITYCLASS());
        repo.delete(temp);
        return temp;
    }

    public Optional<ENTITYCLASS> readone(int id) {
        return repo.findById(id);
    }


    public ENTITYCLASS viewname(String name) {
        return repo.findByempNAME(name);
    }

    public List<ENTITYCLASS> firsstids(int val){
       return repo.idlessthanval(val);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ENTITYCLASS emp=repo.findByempNAME(username);
        if(emp==null){
            throw  new UsernameNotFoundException(username);
        }
        return emp;
    }
}


