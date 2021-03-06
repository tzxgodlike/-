//package HuaWei;
//
//public class H_2020qiu {
//}
//2.一个矩阵5*5取相邻的6个，输入一个6个成员列表，判断是否满足?
//
//        {[1,2,3,4,5]
//
//        [11,12,13,14,15]
//
//        [21,22,23,24,25]
//
//        [31,32,33,34,35]
//
//        [41,42,43,44,45]}
//
//        测试样例：
//
//        解题思路：
//
//        类似于下象棋里的过河的卒，可以理解为从小卒出发点移动五步（每一步不能走斜着），由于每两个位置之间均相邻，首先想到的就是递推关系，a[i]与a[i+1]直接的关系满足：a[i+1]-a[i]=1或者-1或者10或-10。但是这种方法不全面，这种形成的路线为一条折线如图：
//
//        其实还会出现两条折线相交的情况如图：
//
//
//        因此，需要进行扩展，问题的关键在于之前的方法只考虑到了当前点下一步的可选范围（每两步之间的递推关系），对于已经走过的点的可选范围没有保存，因为下一点也许会出现在前一个的可选范围内（如图2所示）。因此，在卒子每前进一步的时候，下一步的可选范围对应的扩大（包含当前点的范围与走过点的范围），因此路线图变为：
//
//
//        代码如下：
//
//        #include<iostream>
//#include<string>
//using namespace std;
//        int main()
//        {
//        int x=0,l[6];
//        int i,ii=0,ans=0,ans1=0,j;
//        while(1)
//        {
//        while(cin>>x){
//        l[ii++]=x;
//        if(cin.get()=='\n') break;
//        }
//        for(i=1;i<=5;i++)
//        {
//        if(ans==0)
//        { for(j=1;j<=1+ans;j++)
//        { if((l[i]==l[i-j]+10) ||(l[i]==l[i-j]-10)|| (l[i]==l[i-j]-1) || (l[i]==l[i-j]+1))
//        ans++;}
//        }
//        else if(ans==1)
//        { for(j=1;j<=1+ans;j++)
//        { if((l[i]==l[i-j]+10) ||(l[i]==l[i-j]-10)|| (l[i]==l[i-j]-1) || (l[i]==l[i-j]+1))
//        ans++;}
//        }
//        else if(ans==2)
//        { for(j=1;j<=1+ans;j++)
//        { if((l[i]==l[i-j]+10) ||(l[i]==l[i-j]-10)|| (l[i]==l[i-j]-1) || (l[i]==l[i-j]+1))
//        ans++;}
//        }
//        else  if(ans==3)
//        { for(j=1;j<=1+ans;j++)
//        { if((l[i]==l[i-j]+10) ||(l[i]==l[i-j]-10)|| (l[i]==l[i-j]-1) || (l[i]==l[i-j]+1))
//        ans++;}
//        }
//        else if(ans==4)
//        { for(j=1;j<=1+ans;j++)
//        { if((l[i]==l[i-j]+10) ||(l[i]==l[i-j]-10)|| (l[i]==l[i-j]-1) || (l[i]==l[i-j]+1))
//        ans++;}
//        }
//
//        }
//        if(ans==5)
//        ans1=1;
//        cout<<ans1<<'\n';
//        ans=0;
//        ans1=0;
//        ii=0;
//        }
//        return 0;}
//        1
//        2
//        3
//        4
//        5
//        6
//        7
//        8
//        9
//        10
//        11
//        12
//        13
//        14
//        15
//        16
//        17
//        18
//        19
//        20
//        21
//        22
//        23
//        24
//        25
//        26
//        27
//        28
//        29
//        30
//        31
//        32
//        33
//        34
//        35
//        36
//        37
//        38
//        39
//        40
//        41
//        42
//        43
//        44
//        45
//        46
//        47
//        48
//        49
//        50
//        3.输入两个整数数组A，B。两者中元素个数相等且相同，但是顺序可以不同，比如1 3 5 2和3 2 1 5.现在想分别删除A，B中部分元素使的A和B剩下的子序列完全相同，求输出的数组A需要删除最少多少元素（注意：B需要删除相同元素）
//        测试样例：
//
//
//        解题思路：其实很简单，可以理解为第二个数组是第一个数组元素顺序打乱后的结果，目的是求两数组删除一些元素使剩下的元素完全一样，（完全一样：顺序一样，个数一样，元素一样）。能实现这个操作其实隐含了一个条件，要想通过删除元素来实现部分元素相同，那么剩下部分元素之间的顺序，打乱前与打乱后的相对关系必须一样。举个例子：1 3 5 2和3 2 1 5这两个数组可以有多种删除方法以之一为例，假设删的是 3 2 ，则原式可以写为1 3 5 2和3 2 1 5，删除黑色字体，你可以发现A种1 5的顺序在B中还是1 5。只有这种才可以满足要求，换句话说，前后相对顺序变了的永远满足不了要求比如说其中的13，通过这种思想可以套用排序算法，找到B在A中对应元素的索引值构成数组C，找到C中最大的递增序列包含元素的个数就是可以实现该操作剩余元素个数，最小删除个数等于总个数-最大剩余个数。
//        代码：
//
//        #include<iostream>
//
//#include<vector>
//using namespace std;
//        int LIS(int *d, int n)  //找到数组里递增子序列的长度
//        { int *B = new int[n];
//        int left, right, len = 1;
//        B[0] = d[0];
//        for (int i = 1; i < n; i++)
//        {    left = 0, right = len-1;
//        while (left <= right)
//        {    int mid = (left+right)/2;
//        if (B[mid] < d[i]) left = mid + 1;
//        else right = mid - 1;
//        }
//        B[left] = d[i];
//        if (left > len-1)
//        len++;
//        }
//        return len;
//        }
//        int main()
//        {
//        int N;
//        int i,ii=0,ans=0,ans1=0,j;
//        while(cin>>N)
//        {
//        char a[N],b[N];
//        int *c=new int[N];
//        for(i=0;i<N;i++)
//        {
//        cin>>a[i];
//        }
//        for(i=0;i<N;i++)
//        {
//        cin>>b[i];
//        }
//        for(i=0;i<=N-1;i++)
//        {
//        for(j=0;j<=N-1;j++)
//        {
//        if(b[j]==a[i])
//        c[i]=j;
//        }
//        }
//        ans=N-LIS(c,N);
//        cout<<ans<<endl;
//        }
//        return 0;
//        }
//