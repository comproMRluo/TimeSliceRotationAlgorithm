package bean;

import body.Cup;

/**
 * @author luowei
 * @create 2020-06-07-12:20
 *
 *      实现waitlist到readylist
 */
public class RuningProducer implements Runnable{

    @Override
    public void run() {
        while (! Cup.isover) {

            int currentNum = Cup.waitList.size();
            System.out.print("");
            for (int i = 0; i < currentNum; i++) {
                Pcb pcb = Cup.waitList.get(i);
                if (pcb.getArriveTime() <= Cup.systemTime) {
                    Cup.readyList.add(pcb);
                    Cup.waitList.remove(pcb);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
            }

        }
    }
}
