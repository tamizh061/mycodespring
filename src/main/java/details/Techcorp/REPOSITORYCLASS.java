package details.Techcorp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface REPOSITORYCLASS extends JpaRepository<ENTITYCLASS,Integer> {
   public  ENTITYCLASS findByempNAME(String name);
   @Query(" from ENTITYCLASS where empID<=:num")
   public List<ENTITYCLASS> idlessthanval(int num);
}
