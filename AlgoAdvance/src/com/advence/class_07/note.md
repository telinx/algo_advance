动态规划本身的目的就是解决 重复计算的问题

满足以下条件
1. 可变参数确定，返回也确定，无后效性（结果和路径无关）
2. 具有重复计算的问题
3. 大规模的问题答案可以用小规模问题递归得到


动态规划步骤
1. 写出递归版本
2. 找出可变参数，画出dp数组
3. 递归base case，初始值填充dp   return aim == 0 ? 1 : 0;
4. 递归可变依赖（位置依赖）        res += recursionProcess(arr, index + 1, aim - i * arr[index]);
5. 推理出这个dp数组
6. 编写代码


动态规划问题
    1. 换钱的方法数
    2. 排成一条线的纸牌博弈问题
    3. 机器人走路问题
    4. 字符串正则匹配问题