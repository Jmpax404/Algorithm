# C

C Programming Practice

# Algorithm

Data Structure and Algorithm

# Nice Questions

## [MagicalPockets](https://www.nowcoder.com/questionTerminal/9aaea0b82623466a8b29a9f1a00b5d35)

```C
#include<iostream>
using namespace std;
//方法一：递归
int count(int n, int*& a, int i, int sum)
{
	if (sum == 0)
		return 1; //找到一组和为sum的组合数；
	if (i == n || sum < 0)
		return 0;//i==n说明没有其他的数来组合，sum<0说明组合不出;
	//从数组的第i为开始，包含a[i],和不包含a[i];
	return count(n, a, i + 1, sum - a[i]) + count(n, a, i + 1, sum);
}
void recursion(int n)//递归
{
	int* a = new int[n];
	for (int i = 0; i < n; i++)
		cin >> a[i];
	cout << count(n, a, 0, 40) << endl;
	delete[] a;
}
//法二:动态规划，对物品组成的体积进行动态规划。
void dynamic(int n)
{
	int* a = new int[n + 1];
	int(*dp)[41] = new int[n + 1][41];//dp[i][j]表示从前i个物品中凑出体积j；
	for (int i = 0; i < 41; i++)
		dp[0][i] = 0;//初始边界:从前0个里凑不出任何体积
	for (int i = 1; i <= n; i++)
	{
		cin >> a[i];
		dp[i][0] = 1; //初始边界:随便从前几个都能凑出0体积
	}
	dp[0][0] = 1;//初始边界:0可以凑出0
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= 40; j++)
		{
			dp[i][j] = dp[i - 1][j];
			if (a[i] <= j)
				dp[i][j] += dp[i - 1][j - a[i]];
		}
	cout << dp[n][40] << endl;
	delete[] a, dp;
}
//法三:动态规划，对容积的可达性进行动态规划。
void dynamic_2(int n)
{
	int a;
	int* dp = new int[41];//dp[i]表示凑出体积i的次数；
	for (int i = 1; i <= 40; i++)
		dp[i] = 0;//初始边界：开始所有体积都没被凑出
	for (int i = 1; i <= n; i++)
	{
		cin >> a;
		for (int j = 40; j >= 1; j--) //逆序，否则要重复更新
			if (dp[j] > 0 && j + a <= 40)
				dp[j + a] += dp[j];//如果j有dp[j]种方式可达，则每种方式加上a就可达j+a
		dp[a]++;
	}
	cout << dp[40] << endl;
	delete[] dp;
}
int main()
{
	int n;
	while (cin >> n)
	{
		//recursion(n);
		//dynamic(n);
		dynamic_2(n);
	}
	return 0;
}
```

