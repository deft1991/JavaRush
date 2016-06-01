package com.javarush.test.NVirt;

/**
 * Created by Golitsyn.SN on 01.06.2016.
 */
public class TestHashTab {
 static VirtTab vt = new VirtTab();

    public static void main(String[] args) {
      /* for(int i =0;i<vt.table.length;i++){
            vt.put(randChar(),randInt());
       }
        for(int i =0;i<vt.table.length;i++) {
            System.out.println(vt.table[i].getKey()+" "+ vt.table[i].getKey());
        }*/
        char[]c = new char[]{'1','2','3','4','5'};
        int[] e = new int[]{2, 3, 4, 5, 6};
        Pair p = new Pair(new char[]{'1','2','3','4','5'},new int[]{2, 3, 4, 5, 6});
        Pair l = new Pair();
        l.setKey(c);

        p.setKey(c);
        System.out.println(p.hashCode());
        vt.put(p.getKey(), p.getValue());
        System.out.println(p.getKey()+" "+ p.getValue());
        System.out.println(vt.get(l.getKey()));
        vt.del(l.getKey());
        System.out.println(vt.get(l.getKey()));
       // vt.put(new char[]{'2','3','4','5','6'}, new int[]{2, 3, 4, 5, 6});

    }
   static char[] randChar(){
        char[]c = new char[(int) (Math.random()*Pair.WORDLEN)];
        for (int i=0;i<c.length;i++){
            c[i]= (char) (Math.random()*1000+1);
        }
        return c;
    }
   static int[] randInt(){
        int[]c = new int[(int) (Math.random()*Pair.NOC)];
        for (int i=0;i<c.length;i++){
            c[i]= (int)(Math.random()*1000+1);
        }
        return c;
    }
}
