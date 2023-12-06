package details.Techcorp;

import jakarta.persistence.Column;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
 class TechcorpApplicationTests {
     @MockBean
	 REPOSITORYCLASS repo;
	 @Autowired
	 SERVICECLASS serv;

	@Test
	public void callfindall(){
		ENTITYCLASS emp1=new ENTITYCLASS(1,"tamil","tom123",8378848,1);
		ENTITYCLASS emp2=new ENTITYCLASS(2,"siva","cat123",833998,3);
		when(repo.findAll()).thenReturn(Stream.of(emp1,emp2).collect(Collectors.toList()));
        assertSame("tamil",serv.listall().get(0).getEmpNAME());

	}

}
