<p>编写一个函数来查找字符串数组中的最长公共前缀。</p>

<p>如果不存在公共前缀，返回空字符串&nbsp;<code>""</code>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<pre>
<strong>输入：</strong>strs = ["flower","flow","flight"]
<strong>输出：</strong>"fl"
</pre>

<p><strong class="example">示例 2：</strong></p>

<pre>
<strong>输入：</strong>strs = ["dog","racecar","car"]
<strong>输出：</strong>""
<strong>解释：</strong>输入不存在公共前缀。</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= strs.length &lt;= 200</code></li> 
 <li><code>0 &lt;= strs[i].length &lt;= 200</code></li> 
 <li><code>strs[i]</code> 仅由小写英文字母组成</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>字典树 | 字符串</details><br>

<div>👍 3180, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**

<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

这个题没什么难度，你把字符串列表看成一个二维数组，然后用一个嵌套 for 循环计算这个二维数组前面有多少列的元素完全相同即可。

如果硬要上点难度的话，你可以考虑用我在 [前缀树算法模板及原理](https://labuladong.online/algo/data-structure/trie/) 中讲过的前缀树结构，把这些字符串转化成前缀树来计算一下公共前缀。

</div>

**标签：字符串，[数组](https://labuladong.online/algo/)**

<div id="solution">

## 解法代码



<div class="tab-panel"><div class="tab-nav">
<button data-tab-item="cpp" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">cpp🤖</button>

<button data-tab-item="python" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">python🤖</button>

<button data-tab-item="java" class="tab-nav-button btn active" data-tab-group="default" onclick="switchTab(this)">java🟢</button>

<button data-tab-item="go" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">go🤖</button>

<button data-tab-item="javascript" class="tab-nav-button btn " data-tab-group="default" onclick="switchTab(this)">javascript🤖</button>
</div><div class="tab-content">
<div data-tab-item="cpp" class="tab-item " data-tab-group="default"><div class="highlight">

```cpp
// 注意：cpp 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        int m = strs.size();
        // 以第一行的列数为基准
        int n = strs[0].length();
        for (int col = 0; col < n; col++) {
            for (int row = 1; row < m; row++) {
                string thisStr = strs[row], prevStr = strs[row - 1];
                // 判断每个字符串的 col 索引是否都相同
                if (col >= thisStr.length() || col >= prevStr.length() ||
                    thisStr[col] != prevStr[col]) {
                    // 发现不匹配的字符，只有 strs[row][0..col-1] 是公共前缀
                    return strs[row].substr(0, col);
                }
            }
        }
        return strs[0];
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        m = len(strs)
        # 以第一行的列数为基准
        n = len(strs[0])
        for col in range(n):
            for row in range(1, m):
                thisStr, prevStr = strs[row], strs[row - 1]
                # 判断每个字符串的 col 索引是否都相同
                if col >= len(thisStr) or col >= len(prevStr) or thisStr[col] != prevStr[col]:
                    # 发现不匹配的字符，只有 strs[row][0..col-1] 是公共前缀
                    return strs[row][:col]
        return strs[0]
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        int m = strs.length;
        // 以第一行的列数为基准
        int n = strs[0].length();
        for (int col = 0; col < n; col++) {
            for (int row = 1; row < m; row++) {
                String thisStr = strs[row], prevStr = strs[row - 1];
                // 判断每个字符串的 col 索引是否都相同
                if (col >= thisStr.length() || col >= prevStr.length() ||
                        thisStr.charAt(col) != prevStr.charAt(col)) {
                    // 发现不匹配的字符，只有 strs[row][0..col-1] 是公共前缀
                    return strs[row].substring(0, col);
                }
            }
        }
        return strs[0];
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func longestCommonPrefix(strs []string) string {
    m := len(strs)
    // 以第一行的列数为基准
    n := len(strs[0])
    for col := 0; col < n; col++ {
        for row := 1; row < m; row++ {
            thisStr, prevStr := strs[row], strs[row-1]
            // 判断每个字符串的 col 索引是否都相同
            if col >= len(thisStr) || col >= len(prevStr) || thisStr[col] != prevStr[col] {
                // 发现不匹配的字符，只有 strs[row][0..col-1] 是公共前缀
                return strs[row][:col]
            }
        }
    }
    return strs[0]
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var longestCommonPrefix = function(strs) {
    let m = strs.length;
    // 以第一行的列数为基准
    let n = strs[0].length;
    for (let col = 0; col < n; col++) {
        for (let row = 1; row < m; row++) {
            let thisStr = strs[row], prevStr = strs[row - 1];
            // 判断每个字符串的 col 索引是否都相同
            if (col >= thisStr.length || col >= prevStr.length ||
                    thisStr.charAt(col) !== prevStr.charAt(col)) {
                // 发现不匹配的字符，只有 strs[row][0..col-1] 是公共前缀
                return strs[row].substring(0, col);
            }
        }
    }
    return strs[0];
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_longest-common-prefix" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_longest-common-prefix"></div></div>
</details><hr /><br />

</div>

</details>
</div>

