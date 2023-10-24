package meituan.t0916;

import java.util.*;

/**
 * @ClassName: Main3
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/16 19:17
 */

public class Main3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();     //怪物数量
        int hp = scan.nextInt();    //小美的血量
        int a = scan.nextInt();     //小美的攻击力
        int[] hArr = new int[n];    //n个怪物的血量
        int[] aArr = new int[n];    //n个怪物的攻击力
        scan.nextLine();
        String line1 = scan.nextLine();
        String line2 = scan.nextLine();
        String[] monsterHp = line1.split(" ");
        String[] monsterAttack = line2.split(" ");
        for (int i = 0; i < hArr.length; i++) {
            hArr[i] = Integer.parseInt(monsterHp[i]);
            aArr[i] = Integer.parseInt(monsterAttack[i]);
        }
        int totalMonsters = getTotalMonsters(hp, a, hArr, aArr);
        System.out.println(totalMonsters);
    }

    public static int getTotalMonsters(int hp, int attack, int[] hArr, int[] aArr) {
        //将n个怪物的信息存入map中：{血量:攻击力}
        Map<Integer, Integer> monsterMap = new HashMap<>();
        for (int i = 0; i < hArr.length; i++) {
            monsterMap.put(hArr[i], aArr[i]);
        }
        //对怪物信息按照血量递减排序
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(monsterMap.entrySet());
        list.sort(((o1, o2) -> {
            int resKey = o2.getKey().compareTo(o1.getKey());
            int resValue = o2.getValue().compareTo(o1.getValue());
            return resKey > resValue ? resKey : resValue;
        }));
        //从大到小开始打怪
        int total = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey() < hp && list.get(i).getValue() < attack) {
                total++;
                hp = list.get(i).getKey();
                attack = list.get(i).getValue();
            }
        }
        return total;
    }
}
