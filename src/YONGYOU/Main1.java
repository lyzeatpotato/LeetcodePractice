package YONGYOU;

import java.util.*;

/**
 * @ClassName: Main1
 * @Description:
 * @author: lyz
 * @date: 2023 09 2023/9/18 19:08
 */

public class Main1 {
    public static void main(String[] args) {
        int n = 6;
        int[][] meetings = new int[][] {{1,2,5}, {2,3,8}, {1,5,10}};
        int firstPerson = 1;
        ArrayList<Integer> allPerson = findAllPerson(n, meetings, firstPerson);

    }

    public static ArrayList<Integer> findAllPerson (int n, int[][] meetings, int firstPerson) {
        // write code here
        //对meetings按照t排序
        for (int i = 0; i < meetings.length; i++) {
            for (int j = i; j < meetings.length; j++) {
                if (meetings[i][2] > meetings[j][2]) {
                    int[] temp = meetings[j];
                    meetings[j] = meetings[i];
                    meetings[i] = temp;
                }
            }
        }
        //根据
        List<Integer> affactedPerson = new ArrayList<>();
        affactedPerson.add(0);
        affactedPerson.add(firstPerson);
        for (int i = 0; i < meetings.length; i++) {
            if (meetings[i][0] == firstPerson || meetings[i][0] == 0) {
                affactedPerson.add(meetings[i][1]);
            } else if (meetings[i][1] == firstPerson || meetings[i][1] == 0) {
                affactedPerson.add(meetings[i][0]);
            } else {
                continue;
            }
        }
        Set<Integer> hashSet = new HashSet<>(affactedPerson);
        ArrayList<Integer> resList = new ArrayList<>(hashSet);
        resList.sort((o1, o2) -> o1 - o2);
        return resList;
    }
}
