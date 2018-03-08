package sk.chgolian.simple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleRepositoryTest {

    @Autowired
    private SimpleRepository simpleRepository;

    @Test
    public void testRetrieveShortInfos() {
        SimpleEntity se1 = new SimpleEntity("first short description", "first long description");
        SimpleEntity se2 = new SimpleEntity("second short description", "second long description");
        SimpleEntity se3 = new SimpleEntity("third short description", "third long description");

        simpleRepository.save(se1);
        simpleRepository.save(se2);
        simpleRepository.save(se3);

        Set<ShortInfo> shortInfos = simpleRepository.retrieveShortInfos();

        assertNotNull(shortInfos);

        assertEquals(3, shortInfos.size());
    }
}
