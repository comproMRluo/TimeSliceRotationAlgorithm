package body;

import bean.Pcb;
import bean.ProcessProducer;
import bean.RuningProducer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author luowei
 * @create 2020-06-07-11:33
 */
public class Cup {
    public static int systemTime = 0;
    public static List<Pcb> readyList = new ArrayList<>();
    public static List<Pcb> waitList = new ArrayList<>();
    public static boolean isover = false;
    public static int timeSlice;
    public static int turnaroundTime = 0;
    public  static void addCpuTime(int time){
        for ( Pcb pcb:readyList) {
            pcb.setCuptime(pcb.getCuptime()+time);
        }
    }


    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入整数时间片(单位秒):");
        timeSlice = scanner.nextInt();
        System.out.print("请输入希望创建的进程总数:");
        int num = scanner.nextInt();

        ProcessProducer processProducer = new ProcessProducer(num);
        RuningProducer runingProducer = new RuningProducer();
        new Thread(processProducer).start();
        new Thread(runingProducer).start();

        while (!isover || readyList.size()!=0){
            if(readyList.size()!=0){                                //时间片不够
                Pcb pcb = readyList.get(0);
                if(pcb.getRemaintime()>timeSlice){
                    Cup.addCpuTime(timeSlice);
                    systemTime += timeSlice;
                    pcb.setRemaintime(pcb.getRemaintime()-timeSlice);
                    System.out.println(pcb);
                    readyList.remove(pcb);
                    readyList.add(pcb);
                    Thread.sleep(timeSlice*1000);
                }else{                                              //时间片够
                    Cup.addCpuTime(pcb.getRemaintime());
                    systemTime += pcb.getRemaintime();
                    pcb.setFinishTime(systemTime);
                    pcb.setRemaintime(0);
                    turnaroundTime += pcb.getFinishTime()-pcb.getArriveTime();
                    System.out.println(pcb);
                    readyList.remove(pcb);
                    Thread.sleep(timeSlice*1000);
                }

            }else{
                systemTime += timeSlice;
                System.out.println("NULL");
                Thread.sleep(timeSlice*1000);
            }

        }
        System.out.println("运行结束,平均周转时间为: " +turnaroundTime/num);

    }
}
