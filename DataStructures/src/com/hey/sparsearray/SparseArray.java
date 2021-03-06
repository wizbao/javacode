package com.hey.sparsearray;

/**
 * @author hey
 * @creat 2020-04-15-16:57
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始数组
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print("\t");
                System.out.print(data);
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }

        }
        //创建对应的稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        //给稀疏数组赋值
        int count = 0;
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j]!=0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组
        for (int[] row : sparseArr) {
            for (int data : row) {
                System.out.print("\t");
                System.out.print(data);
            }
            System.out.println();
        }
        //再由稀疏数组转换为原数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //在读取稀疏数组后几行的数据(第二行开始),并赋值给原数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出原数组
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.print("\t");
                System.out.print(data);
            }
            System.out.println();
        }
    }
}
