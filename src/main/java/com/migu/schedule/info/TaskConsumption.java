package com.migu.schedule.info;

/**
 * @Author: liuhui
 * @Description:
 * @Date: Created in 2018/6/20
 */
public class TaskConsumption {
    private int taskId;
    private int consumption;
    private int nodeId;

    public TaskConsumption(int taskId ,int consumption) {
        this.taskId = taskId;
        this.consumption = consumption;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return "TaskConsumption{" +
                "taskId=" + taskId +
                ", consumption=" + consumption +
                '}';
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }
}
