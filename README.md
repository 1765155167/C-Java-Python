## C++
# sort 各种排序算法
## java
## python
#查询分支的合并情况
dev branch and hqf branch.
git log --graph --pretty==oneline --abbrev-comit
master应该为最稳定的分支
dev为开发中分支，不定时向master合并
个人创建自己的分支然后向dev分支合并

修复bug.
- 当正在hqf分支中工作室突然需要临时修改master分支中的bug，可以先临时保存当前进度再去修改
- git stash 保存当前进度 
- git stash pop 恢复进度
- git cherry-pick <05946> 把修改bug提交的部分复制到当前分支中<05946>为bug分支commit
