package org.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> changes = new HashMap<>();
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                if (changes.containsKey(bills[i])) {
                    int count = changes.get(bills[i]);
                    changes.put(bills[i], count + 1);
                } else {
                    changes.put(bills[i], 1);
                }
            }

            if (bills[i] == 10) {
                if (changes.containsKey(5)) {
                    int count = changes.get(5);
                    if (count == 0) {
                        return false;
                    }
                    if (count == 1) {
                        changes.remove(5);
                    } else {
                        changes.put(5, count - 1);
                    }
                } else {
                    return false;
                }
                if (changes.containsKey(bills[i])) {
                    int count = changes.get(bills[i]);
                    changes.put(bills[i], count + 1);
                } else {
                    changes.put(bills[i], 1);
                }
            }

            if (bills[i] == 20) {
                if (!changes.containsKey(5)) {
                    return false;
                }

                if (changes.containsKey(5) && !changes.containsKey(10)) {
                    int count = changes.get(5);
                    if (count < 3) {
                        return false;
                    }
                    if (count == 3) {
                        changes.remove(5);
                    } else {
                        changes.put(5, count - 3);
                    }
                }
                if (changes.containsKey(5) && changes.containsKey(10)) {
                    int count10 = changes.get(10);
                    int count5 = changes.get(5);
                    if (count5*5+count10*10<15){
                        return false;
                    } else {
                        if(count10==1){
                            changes.remove(10);
                        } else {
                            changes.put(10, count10-1);
                        }
                        if(count5==1){
                            changes.remove(5);
                        } else {
                            changes.put(5, count5-1);
                        }
                    }
                }
                if (changes.containsKey(bills[i])) {
                    int count = changes.get(bills[i]);
                    changes.put(bills[i], count + 1);
                } else {
                    changes.put(bills[i], 1);
                }
            }

        }

        return true;
    }
}