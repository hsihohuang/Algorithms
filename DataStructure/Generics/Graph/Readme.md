#### 測試檔testFile/strGraph.txt之圖形

<img src="testGraph.png" width="500">

### 讀檔建圖說明

格式如下：<p>
<ol>1. 檔案的第一行是每個節點的值，以" "空白字元做區隔</ol>
<blockquote>舉例來說: testFile/strGraph.txt中第一行是A B C D E F G H，代表要插入8個節點，值分別為A B C D E F G H，
<br>會按照檔案中值的順序依序被加入vertices list中</blockquote>
<ol>2. 第一行以下，每行代表vertices中某index的節點(第一個數字)和哪些index的點相鄰(第二與之後的數字)，一樣以" "空白字元做區隔</ol>
<blockquote>舉例來說: testFile/strGraph.txt中第二行是0 1 2，代表vertices中，index 0的點和index 1、index 2相鄰，
<br>也就是，A與B、C相鄰</blockquote>
