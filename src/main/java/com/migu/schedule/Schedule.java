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

    public Integer init() {
        // TODO 方法未实现

        if (registSet == null || registSet.isEmpty()) {
            registSet = new HashSet<Integer>();
        } else {
            registSet = null;
            System.gc();
        }

        blockingQueue = new ConcurrentLinkedQueue<Integer>();

        taskMap = new HashMap<Integer, Integer>();

        list = new ArrayList<TaskInfo>();
        return ReturnCodeKeys.E001;
    }


    public Integer registerNode(Integer nodeId) {
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

    public Integer unregisterNode(Integer nodeId) {
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


    public Integer addTask(Integer taskId, Integer consumption) {
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


    public Integer deleteTask(Integer taskId) {
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


    public Integer scheduleTask(Integer threshold) {
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


    public int queryTaskStatus(List<TaskInfo> tasks) {
        // TODO 方法未实现
        if(tasks == null){
            return ReturnCodeKeys.E016;
        }
        return ReturnCodeKeys.E000;
    }

}
