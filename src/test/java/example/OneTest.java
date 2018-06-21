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

    /*assertEquals("schedule", s.registerNode(1));

    assertEquals("schedule", s.registerNode(2));

    assertEquals("schedule", s.unregisterNode(1));

    assertEquals("schedule", s.addTask(1,1));

    assertEquals("schedule", s.addTask(2,2));

    assertEquals("schedule", s.deleteTask(1));

    assertEquals("schedule", s.scheduleTask(1));

    List<TaskInfo> list = new ArrayList<TaskInfo>();
    TaskInfo taskInfo = new TaskInfo();
    taskInfo.setTaskId(1);
    taskInfo.setNodeId(1);
    list.add(taskInfo);*/
   /* assertEquals("schedule", list);*/

  }

}