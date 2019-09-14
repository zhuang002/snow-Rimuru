/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rimuru;

import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class Rimuru {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        String n=sc.nextLine();
        int result=calculateByNumber(n);
        System.out.println(result);
    }

    private static int calculateByNumber(String n) {
        if (n.length()==0) return 0;
        
        int c=n.charAt(0)-'0';
        if (n.length()==1)
        {
            if (c<2) return 0;
            if (c==2) return 1;
            if (c>=3) return 2;
        }
        if (c<2)
            return calculateByDigits(n.length()-1);
        else if (c==2)
            return calculateByDigits(n.length()-1)+calculateByNumber(n.substring(1));
        else if (c==3)
            return calculateByDigits(n.length()-1)*2+calculateByNumber(n.substring(1));
        else
            return calculateByDigits(n.length());
    }


    private static int calculateByDigits(int digits) {
        if (digits==0) return 0;
        int result=0;
        for (int i=1;i<=digits;i++) {
            result+=Math.pow(2, i);
        }
        return result;
    }
    
}
