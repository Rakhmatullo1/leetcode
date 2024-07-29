package org.example;

/**
 * @author Rahmatullo Omonov
 * Date: ${DATE}
 */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.numTeams(new int[]{2,1,3});
    }

    public int numTeams(int[] rating) {
        int bruteForce =0;


        for(int i=0; i<rating.length; i++) {
            for(int j=i+1; j<rating.length; j++) {
                for(int k=j+1; k<rating.length; k++) {
                    if(rating[i]>rating[j] && rating[j]>rating[k]) {
                        bruteForce++;
                    } else if (rating[i]<rating[j] && rating[j]<rating[k]) {
                        bruteForce++;
                    }

                }
            }
        }

        return bruteForce;
    }
}