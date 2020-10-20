package com.app.resultArray;

class FuzzyLogicArray{

    public int[][] fuzzyLogic;
    public String[] action;


    /**
     * 构造函数: 生成一个模糊控制器
     * @param fuzzyLogicArray: 模糊函数组成的模糊控制逻辑矩阵
     * @param actionArray: 模糊函数对应的action矩阵
     *
     * */
    public FuzzyLogicArray(int[][] fuzzyLogicArray, String[] actionArray) {
        this.fuzzyLogic = fuzzyLogicArray;
        this.action = actionArray;
    }

    /**
     * 单向量检查
     * */
    public Boolean checkVector(int[] fuzzyVector, int[] vector){
        int fuzzyVectorSize = fuzzyVector.length;
        int vectorSize = vector.length;

        // 检查target向量和source向量的维度是否相等
        // 不等则抛出"The Size is not equal"异常
        if(fuzzyVectorSize != vectorSize){
            throw new RuntimeException("矩阵维度不匹配");
        }

        // 检查source向量和target向量是否相等
        for (int i = 0; i < fuzzyVectorSize; i++) {
            Integer targetValue = fuzzyVector[i];
            Integer sourceValue = vector[i];
            if(targetValue != 2 && !targetValue.equals(sourceValue)){
                // System.out.println("index  " + i + " pass");
                return false;
            }
            // System.out.println("index  " + i + " failed");
        }
        return true;
    }

    /**
     * 执行模糊控制
     * */
    public void run(int[] target){

        // 遍历fuzzyLogic
        for( int i = 0; i< fuzzyLogic.length; i++ ){
            Boolean res = checkVector(fuzzyLogic[i], target);
            if(res){
                System.out.println("匹配到表达式 " + i + " : " +  action[i]);
                return;
            }
            System.out.println("表达式 " + i + " failed");

        }

        System.out.println("正常");
    }


}

/**
 * @author Jupyter
 */
public class ArrayMatch{
    public static void main(String[] args) {

        // fuzzyLogic
        int[][] fuzzyLogic = {
                { 1, 0, 1, 0, 1 },
                { 1, 0, 0, 0, 0 },
                { 1, 2, 0, 0, 0 },
                { 1, 1, 2, 1, 0 },
                { 1, 0, 2, 2, 0 }
        };

        // action for fuzzyLogic
        String[] actions = {
                "Reason A",
                "Reason B",
                "Reason C",
                "Reason D",
                "Reason E"
        };

        int[] testVector = { 1, 0, 1, 0, 1 };
        FuzzyLogicArray fuzzyLogicArray = new FuzzyLogicArray(fuzzyLogic, actions);
        fuzzyLogicArray.run(testVector);

    }
}
