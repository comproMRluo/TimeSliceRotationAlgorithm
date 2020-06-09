package bean;

import body.Cup;

import java.util.Random;

/**
 * @author luowei
 * @create 2020-06-07-11:01
 */
//随机产生进程PCB放在等待队列之中
public class ProcessProducer implements Runnable{

    private int processNum;
    private int id=1; //进程id号唯一标识


    public ProcessProducer(int processNum) {
        this.processNum = processNum;
    }

    @Override
    public void run(){
        //            种子:避免一直生成统一随机数
        long seed = System.nanoTime();
        Random random = new Random(seed);

        while (processNum>0){
            int ram = random.nextInt(5);//设置随机产生值
            if(ram==4) {
//              设置优先级
//              优先级范围
                int processProducerBound = 5;
                int priority = random.nextInt(processProducerBound);
//              设置完成时间
                int alltimeBound = 20;
                int alltime = random.nextInt(alltimeBound);
//              设置到达时间
                int arriveTime = Cup.systemTime;

                Pcb pcb = new Pcb(id++, priority, arriveTime, alltime+1);
                Cup.waitList.add(pcb);
                processNum--;

                if(processNum==0){
                    Cup.isover=true;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("cup异常");
                }
            }else{

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("cup异常");
                }
            }
        }


    }
}
