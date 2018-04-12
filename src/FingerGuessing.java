/**
 * Created by 捷宝宝 on 2017/5/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class FingerGuessing {
    private String[] op = new String[]{"布", "剪刀", "石头"};
    Random r = new Random();
    private int wj = 0;
    private int dn = 0;
    private int count = 0;

    //利用随机数决定电脑出拳
    private int go() {
        int k = r.nextInt(3);
        System.out.println("电脑:" + op[k]);
        return k;
    }

    //竞赛时通过数字代替字符串
    private void compare(int i) {
        count++;
        System.out.println("玩家:" + op[i - 1]);
        int k = go();
        if (i - 1 == k) {
            System.out.println("打平");
        } else if (i - 1 - k == 1 || i - 1 - k == -2) {
            System.out.println("玩家获胜");
            wj++;
        } else {
            System.out.println("电脑获胜");
            dn++;
        }
    }

    //记录游戏局数
    private void info() {
        System.out.println("共" + count + "盘");
        System.out.println("玩家获胜" + wj + "盘");
        System.out.println("电脑获胜" + dn + "盘");
        System.out.println("打平" + (count - wj - dn) + "盘");
    }

    public void start() {
        String xz = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println("\n请选择:\n1.布\n2.剪刀\n3.石头\n结束请输入exit");
            try {
                xz = br.readLine();
                if (xz.equalsIgnoreCase("exit")) {
                    info();
                    continue;
                }
                if (!xz.equals("1") && !xz.equals("2") && !xz.equals("3")) {
                    System.out.println("选择错误,请重新选择");
                    continue;
                }
                compare(Integer.parseInt(xz));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } while (!xz.equals("exit"));
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new FingerGuessing().start();
    }
}
