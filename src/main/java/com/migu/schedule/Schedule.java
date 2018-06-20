package com.migu.schedule;


import com.migu.schedule.constants.ReturnCodeKeys;
import com.migu.schedule.info.TaskInfo;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/*
*类名和方法不能修改
 */
public class Schedule {
    //节点
    private Set<Integer> registSet;
    //任务
    private Queue<Integer> blockingQueue;
    //任务 消耗
    private Map<Integer, Integer> taskMap;
    //
    private List<TaskInfo> list;

    public int init() {
        // TODO 方法未实现

        if (registSet == null || registSet.isEmpty()) {
            registSet = new HashSet<Integer>();
        } else {
            registSet = null;
            System.gc();
        }
        if (blockingQueue.isEmpty() || blockingQueue == null) {
            blockingQueue = new ConcurrentLinkedQueue<Integer>();
        } else {
            blockingQueue = null;
            System.gc();
        }
        if (taskMap.isEmpty() || taskMap == null) {
            taskMap = new HashMap<Integer, Integer>();
        } else {
            taskMap = null;
            System.gc();
        }
        if (list.isEmpty() || list == null) {
            list = new ArrayList<TaskInfo>();
        } else {
            list = null;
            System.gc();
        }
        return ReturnCodeKeys.E001;
    }


    public int registerNode(int nodeId) {
        // TODO 方法未实现
        if (registSet.contains(nodeId)) {
            return ReturnCodeKeys.E005;
        }
        if (nodeId <= 0) {
            return ReturnCodeKeys.E004;
        } else {
            registSet.add(nodeId);
            return ReturnCodeKeys.E003;
        }
    }

    public int unregisterNode(int nodeId) {
        // TODO 方法未实现
        if (nodeId <= 0) {
            return ReturnCodeKeys.E004;
        } else if (!registSet.contains(nodeId)) {
            return ReturnCodeKeys.E007;
        } else {
            registSet.remove(nodeId);
            return ReturnCodeKeys.E006;
        }
    }


    public int addTask(int taskId, int consumption) {
        // TODO 方法未实现
        if (taskId <= 0) {
            return ReturnCodeKeys.E009;
        }
        if (blockingQueue.contains(taskId)) {
            return ReturnCodeKeys.E010;
        } else {
            blockingQueue.add(taskId);
            taskMap.put(taskId, consumption);
            return ReturnCodeKeys.E008;
        }

    }


    public int deleteTask(int taskId) {
        // TODO 方法未实现
        if (taskId <= 0) {
            return ReturnCodeKeys.E009;
        }
        if (!blockingQueue.contains(taskId)) {
            return ReturnCodeKeys.E012;
        } else {
            blockingQueue.remove(taskId);
            taskMap.remove(taskId);
            return ReturnCodeKeys.E011;
        }
    }


    public int scheduleTask(int threshold) {
        // TODO 方法未实现
        if (threshold < 0) {
            return ReturnCodeKeys.E002;
        }
        if (!blockingQueue.isEmpty()) {
            Integer max = Collections.max(taskMap.values());
            Integer sum = 0;
            for (Integer i : taskMap.values()) {
                sum += i;
            }
            if ((max - sum + max) > threshold) {
                return ReturnCodeKeys.E014;
            }
            Integer average = sum/(taskMap.size());

            for (Integer taskId : blockingQueue) {
                for (Integer nodeId : registSet) {
                    TaskInfo taskInfo = new TaskInfo();
                    taskInfo.setNodeId(nodeId);
                    taskInfo.setTaskId(taskId);
                    list.add(taskInfo);
                    break;
                }
            }
        }
     return ReturnCodeKeys.E013;
    }


    public List<TaskInfo> queryTaskStatus(List<TaskInfo> tasks) {
        // TODO 方法未实现
        if (tasks == null) {
            //return ReturnCodeKeys.E016;
            return tasks;
        }
        List<TaskInfo> taskList = new ArrayList();
        for (TaskInfo task : tasks) {
            for (TaskInfo taskInfo : list) {
                if(task.getTaskId()==taskInfo.getTaskId()){
                    taskList.add(taskInfo);
                }
            }
        }
        return taskList;
    }

}
