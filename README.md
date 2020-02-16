## C++

# Android
## AndroidManifest.xml
1. application:android:resizeableActivity="false"禁用分屏功能
2. MainActivity:android:screenOrientation="portrait"设置只支持竖屏
3. MainActivity: android:configChanges="orientation|keybroadHidden|screenSize|screenLayout"
   - 不管进入多窗口模式，还是横竖屏切换，活动都不会重新创建，而是将活动变化事件通知到Activity中的onConfigurationChanged()方法中
   - orientation：消除横竖屏的影响
   - keyboardHidden：消除键盘的影响
   - screenSize：消除屏幕大小的影响
4. 设置某个活动支支持竖屏或者横屏
```java
setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//以竖屏显示
setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//以横屏显示
```
## bumptech
图片加载库 可以加载网络图片、GIF图片、甚至是本地视频、加载图片时会自动压缩，防止内存溢出问题
[bumptech ](https://github.com/bumptech/glide)

## LitePal
数据库操作
[LitePal](https://github.com/LitePalFramework/LitePal)

## 列表布局
### ListView
### RecyclerView
## MaterialDesign UI设计理念
## CircleImageView 将ImageView变成圆形
## CardView 卡片式布局
# git
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
