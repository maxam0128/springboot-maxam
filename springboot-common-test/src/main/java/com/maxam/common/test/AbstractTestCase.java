package com.maxam.common.test;

import com.maxam.common.test.config.TestConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

/**
 * @author fanjinlong
 * @date 2019-04-15 15:59
 **/
@SpringBootTest(classes = TestConfig.class,webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AbstractTestCase extends AbstractTransactionalTestNGSpringContextTests {
}
