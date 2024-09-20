<p>给定一个仅包含数字&nbsp;<code>2-9</code>&nbsp;的字符串，返回所有它能表示的字母组合。答案可以按 <strong>任意顺序</strong> 返回。</p>

<p>给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。</p>

<p><img src="https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2021/11/09/200px-telephone-keypad2svg.png" style="width: 200px;" /></p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>digits = "23"
<strong>输出：</strong>["ad","ae","af","bd","be","bf","cd","ce","cf"]
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>digits = ""
<strong>输出：</strong>[]
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>digits = "2"
<strong>输出：</strong>["a","b","c"]
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>0 &lt;= digits.length &lt;= 4</code></li> 
 <li><code>digits[i]</code> 是范围 <code>['2', '9']</code> 的一个数字。</li> 
</ul>

<details><summary><strong>Related Topics</strong></summary>哈希表 | 字符串 | 回溯</details><br>

<div>👍 2901, 👎 0<span style='float: right;'><span style='color: gray;'><a href='https://github.com/labuladong/fucking-algorithm/discussions/939' target='_blank' style='color: lightgray;text-decoration: underline;'>bug 反馈</a> | <a href='https://labuladong.online/algo/fname.html?fname=jb插件简介' target='_blank' style='color: lightgray;text-decoration: underline;'>使用指南</a> | <a href='https://labuladong.online/algo/images/others/%E5%85%A8%E5%AE%B6%E6%A1%B6.jpg' target='_blank' style='color: lightgray;text-decoration: underline;'>更多配套插件</a></span></span></div>

<div id="labuladong"><hr>

**通知：已完成网站教程、网站习题、配套插件中所有多语言代码的校准，解决了之前 chatGPT 翻译可能出错的问题~**

<details><summary><strong>labuladong 思路</strong></summary>

<div id="labuladong_solution_zh">

## 基本思路

你需要先看前文 [回溯算法详解](https://labuladong.online/algo/essential-technique/backtrack-framework/) 和 [回溯算法团灭子集、排列、组合问题](https://labuladong.online/algo/essential-technique/permutation-combination-subset-all-in-one/)，然后看这道题就很简单了，无非是回溯算法的运用而已。

组合问题本质上就是遍历一棵回溯树，套用回溯算法代码框架即可。

</div>

**标签：[回溯算法](https://labuladong.online/algo/)，[数学](https://labuladong.online/algo/)**

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

#include <vector>
#include <string>
#include <unordered_map>

class Solution {
    // 每个数字到字母的映射
    std::unordered_map<char, std::string> mapping = {
        {'2', "abc"}, {'3', "def"}, {'4', "ghi"}, {'5', "jkl"},
        {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}
    };

    std::vector<std::string> res;
    std::string sb;

public:
    std::vector<std::string> letterCombinations(std::string digits) {
        if (digits.empty()) {
            return res;
        }
        // 从 digits[0] 开始进行回溯
        backtrack(digits, 0);
        return res;
    }

    // 回溯算法主函数
    void backtrack(const std::string& digits, int start) {
        if (sb.size() == digits.size()) {
            // 到达回溯树底部
            res.push_back(sb);
            return;
        }

        // 回溯算法框架
        char digit = digits[start];
        for (char c : mapping[digit]) {
            // 做选择
            sb.push_back(c);
            // 递归下一层回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            sb.pop_back();
        }
    }
};
```

</div></div>

<div data-tab-item="python" class="tab-item " data-tab-group="default"><div class="highlight">

```python
# 注意：python 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
# 本代码已经通过力扣的测试用例，应该可直接成功提交。

class Solution:
    # 每个数字到字母的映射
    mapping = [
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    ]

    def __init__(self):
        self.res = []
        self.sb = []

    def letterCombinations(self, digits: str) -> List[str]:
        if not digits:
            return self.res
        # 从 digits[0] 开始进行回溯
        self.backtrack(digits, 0)
        return self.res

    # 回溯算法主函数
    def backtrack(self, digits: str, start: int) -> None:
        if len(self.sb) == len(digits):
            # 到达回溯树底部
            self.res.append(''.join(self.sb))
            return

        # 回溯算法框架
        digit = ord(digits[start]) - ord('0')
        for c in self.mapping[digit]:
            # 做选择
            self.sb.append(c)
            # 递归下一层回溯树
            self.backtrack(digits, start + 1)
            # 撤销选择
            self.sb.pop()
```

</div></div>

<div data-tab-item="java" class="tab-item active" data-tab-group="default"><div class="highlight">

```java
class Solution {
    // 每个数字到字母的映射
    String[] mapping = new String[] {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return res;
        }
        // 从 digits[0] 开始进行回溯
        backtrack(digits, 0);
        return res;
    }

    // 回溯算法主函数
    void backtrack(String digits, int start) {
        if (sb.length() == digits.length()) {
            // 到达回溯树底部
            res.add(sb.toString());
            return;
        }

        // 回溯算法框架
        int digit = digits.charAt(start) - '0';
        for (char c : mapping[digit].toCharArray()) {
            // 做选择
            sb.append(c);
            // 递归下一层回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```

</div></div>

<div data-tab-item="go" class="tab-item " data-tab-group="default"><div class="highlight">

```go
// 注意：go 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

func letterCombinations(digits string) []string {
    if len(digits) == 0 {
        return []string{}
    }
    // 每个数字到字母的映射
    var mapping = []string{
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz",
    }
    var res []string
    // 从 digits[0] 开始进行回溯
    backtrack(digits, 0, "", &res, mapping)
    return res
}

// 回溯算法主函数
func backtrack(digits string, start int, combination string, res *[]string, mapping []string) {
    if len(combination) == len(digits) {
        // 到达回溯树底部
        *res = append(*res, combination)
        return
    }

    // 回溯算法框架
    digit := digits[start] - '0'
    for _, c := range mapping[digit] {
        // 做选择
        backtrack(digits, start+1, combination+string(c), res, mapping)
        // 递归下一层回溯树
        // Note: The following comment is not needed as there is no action taken for "undo the choice"
        // 撤销选择
    }
}
```

</div></div>

<div data-tab-item="javascript" class="tab-item " data-tab-group="default"><div class="highlight">

```javascript
// 注意：javascript 代码由 chatGPT🤖 根据我的 java 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码已经通过力扣的测试用例，应该可直接成功提交。

var letterCombinations = function(digits) {
    // 每个数字到字母的映射
    const mapping = [
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    ];

    let res = [];
    let sb = "";

    if (digits === "") {
        return res;
    }

    // 从 digits[0] 开始进行回溯
    // @visualize status(sb)
    function backtrack(digits, start) {
        // 回溯算法主函数
        if (sb.length === digits.length) {
            // 到达回溯树底部
            res.push(sb);
            return;
        }

        // 回溯算法框架
        let digit = digits.charCodeAt(start) - '0'.charCodeAt(0);
        for (let c of mapping[digit].split("")) {
            // 做选择
            // @visualize choose(c)
            sb += c;
            // 递归下一层回溯树
            backtrack(digits, start + 1);
            // 撤销选择
            // @visualize unchoose()
            sb = sb.slice(0, -1);
        }
    }

    backtrack(digits, 0);
    return res;
};
```

</div></div>
</div></div>

<hr /><details open hint-container details><summary style="font-size: medium"><strong>🌟🌟 算法可视化 🌟🌟</strong></summary><div id="data_letter-combinations-of-a-phone-number" data="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"></div><div class="resizable aspect-ratio-container" style="height: 100%;">
<div id="iframe_letter-combinations-of-a-phone-number"></div></div>
</details><hr /><br />

</div>

</details>
</div>

