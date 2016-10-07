/**
 * Created by zjladmin on 2016/9/21.
 */
public class Main18 {
    public static void main(String[] args) {
        int nums[]={9,9,8,5,5,3,3,1,1,1};
        System.out.println(doFindIsosceles(nums));
    }
    public static int doFindIsosceles (int[] sides){
        //1.共有多少种长度的边
        int type = 0;
        int lastSideLength = 0;
        for (int i = 0; i < sides.length; i++) {
            if( sides[i] != lastSideLength ){
                lastSideLength = sides[i];
                type++;
            }
        }
        //2.每种边长最大情况下可以生成几个等腰三角形
        int []sideLength = new int[type];//每条边的边长
        int []assembledNum = new int[type];//最大可以组成的最多三角形数
        boolean []hasLeft = new boolean[type];//是否有多出来的边
        int curPos = 0;//当前处理到第几种边长
        lastSideLength = sides[0];
        for (int i = 0, numOfSide=0; i < sides.length; i++) {
            if( sides[i] != lastSideLength){
                assembledNum[curPos] = numOfSide / 2;
                hasLeft[curPos] = numOfSide % 2 > 0;
                sideLength[curPos++] = lastSideLength;

                lastSideLength=sides[i];   //更新正在处理的边长 ?


                sideLength[curPos] = lastSideLength;
                numOfSide = 1;
            }else{

                assembledNum[curPos]++;  //正在处理的边长数量+1?

                if( i == sides.length-1 ){
                    assembledNum[curPos] = numOfSide / 2;
                    hasLeft[curPos] = numOfSide % 2 > 0;
                    sideLength[curPos] = lastSideLength;
                }
            }
        }

        //计算最大可能性
        int sum = 0;
        int usedPos = 0;//从多到少搜索缺失的底边
        int desPos = assembledNum.length-1;//拆解的位置
        for (int i = 0; i < assembledNum.length; i++) {
            int toFind = assembledNum[i];//需要找到多少条底边
            while( toFind > 0 ){
                for(; usedPos < hasLeft.length; usedPos++ ){
                    if( hasLeft[usedPos] && sideLength[i]*2 > sideLength[usedPos] ){
                        toFind--;

                        hasLeft[usedPos]=false;  //此边长多出来的边已经被用掉 ?

                    }
                }
                if( usedPos >= hasLeft.length && toFind > 0){
                    //需要拆三角形了 从小向大去拆
                    if( assembledNum[desPos] <= 0 ){
                        desPos--;
                        continue;
                    }
                    if( desPos > i ){
                        //拆解比当前边更短的三角形
                        int remain = assembledNum[desPos]*2 - toFind ;//拆了后剩余的边数
                        if( remain >= 0 ){
                            toFind = 0;
                            assembledNum[desPos] = remain / 2;
                            if( remain % 2 == 1 ){
                                hasLeft[desPos] = true;
                                usedPos = desPos;
                            }
                        }else{
                            //竟然不够拆的
                            assembledNum[desPos] = 0;
                            toFind = toFind - assembledNum[desPos]*2;
                        }
                    }else if( desPos == i ){
                        //拆解当前的三角形了
                        int desNum = toFind/2 + toFind%2;//需要拆的个数

                        assembledNum[desPos]-=desNum;//拆除后剩余的个数  ?

                        if( toFind % 2 == 1 ){
                            hasLeft[i] = true;
                            usedPos = i;
                        }
                        toFind = 0;
                    }else{
                        //出错了
                    }
                }
            }
            if(assembledNum[i]>0)
		 sum+=assembledNum[i];//汇总三角形个数?
        }
        return sum;
    }
}
