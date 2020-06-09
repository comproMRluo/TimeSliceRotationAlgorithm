package bean;

/**
 * @author luowei
 * @create 2020-06-07-9:51
 */
public class Pcb {
    private int id;          	//进程标识
    private int priority;	//优先权  时间轮转不考虑优先权
    private int arriveTime;	//进程到达时间
    private int alltime;	//进程需要的总运行时间 不变的值
    private int remaintime;	//剩余的运行时间 每个时间片对其进行修改
    private int cuptime;	//cup占用时间 每个时间片记录一次
    private int finishTime;	//完成的时间  当remaintime=0时获取systemtime值
    private int flag;		//标志该进程是否被调度过

    public Pcb(int id, int priority, int arriveTime, int alltime) {
        this.id = id;
        this.priority = priority;
        this.arriveTime = arriveTime;
        this.alltime = alltime;
        this.remaintime = alltime;
        this.finishTime = -1;
        this.flag = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(int arriveTime) {
        this.arriveTime = arriveTime;
    }

    public int getAlltime() {
        return alltime;
    }

    public void setAlltime(int alltime) {
        this.alltime = alltime;
    }

    public int getRemaintime() {
        return remaintime;
    }

    public void setRemaintime(int remaintime) {
        this.remaintime = remaintime;
    }

    public int getCuptime() {
        return cuptime;
    }

    public void setCuptime(int cuptime) {
        this.cuptime = cuptime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", priority=" + priority +
                ", arriveTime=" + arriveTime +
                ", alltime=" + alltime +
                ", remaintime=" + remaintime +
                ", cuptime=" + cuptime +
                ", finishTime=" + finishTime ;
    }
}
