package example;

import com.migu.schedule.Schedule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OneTest {
  @Test
  public void testFoo() throws Exception {
    One one = new One();
    //Test foo
    assertEquals("foo", one.foo());
  }

  @Test
  public void testScheduleTask1() throws Exception {
    Schedule s = new Schedule();
    //Test foo
    assertEquals("schedule", s.init());

  }

}