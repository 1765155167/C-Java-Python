# Android系统架构
1. Linux内核层
2. 系统运行库层
3. 应用框架层
4. 应用层
# Android四大组件
1. 活动（Activity）

2. 服务（Service）

3. 广播接收器（Broadcast Receiver）

4. 内容提供器（Content Provider）

# Android 布局
## 布局公有属性
1. layout_width 宽
2. layout_height 高
3. layout_margin+方位 相对于其他部件距离
4. padding +方位 内部相对于边框距离
5. gravity 内容相对于边框
6. layout_gravity 边框相对于父部件
## LinterLayout
1. android:orientation="horizontal" 垂直
2. android:orientation="vertical" 水平
## RelativeLayout
1. 属性值是true或false
  - android:layout_centerHrizontal 水平居中
  - android:layout_centerVertical 垂直居中
  - android:layout_centerInparent 相对于父元素完全居中。
  - android:layout_alignParentBottom 位于父元素的下边缘
  - android:layout_alignParentTop 位于父元素的上边缘
  - android:layout_alignParentLeft 位于父元素的左边缘
  - android:layout_alignParentRight 位于父元素的右边缘
2. 属性值是"@id/*"
  - android:layout_below 在某元素的下方
  - android:layout_above 在某元素的上方
  - andorid:layout_toRightOf 在某元素的右方
  - android:layout_toLeftOf 在某元素的左方
  - android:layout_alignBottom 和某元素下方对齐
  - android:layout_alignTop 和某元素上方对齐
  - android:layout_alignRight 和某元素右方对齐
  - android:layout_alignLeft 和某元素左方对齐
3. 属性值是数值
  - android:layout_marginLeft 离某元素左边缘的距离
  - android:layout_marginRight 离某元素右边缘的距离
  - android:layout_marginTop 离某元素上边缘的距离
  - android:layout_marginBottom 离某元素下边缘的距离
## FrameLayout
从左上角开始，后面的会覆盖前面的控件

# Android 启动模式
1. 系统默认的启动模式:Standard
在这种模式下，谁启动了这个Activity,那么这个Activity就运行在启动它的那个Activity的任务栈中
2. 栈顶复用模式：SingleTop
如果要启动的新的Activity已经位于任务栈的栈顶，那么此Activity不会被重新创建，同时它的onNewIntent方法被回调，并且这个Activity的onCreate,onStart不会被系统调用
3. 栈内复用模式：SingTask
当一个具有singleTask模式的Activity请求启动后，比如Activity A，系统首先寻找任务栈中是否已存在Activity A的实例，如果已经存在，那么系统就会把A调到栈顶并调用它的onNewIntent方法，如果Activity A实例不存在，就创建A的实例并把A压入栈中。
4. 单实例模式：SingleInstance
它除了具有singleTask模式所有的特性外，还加强了一点，那就是具有此种模式的Activity只能单独位于一个任务栈中，
## 设置启动模式
1. AndroidManifest.xml
```xml
<activity android:launchMode="SingleTop"/"SingTask"/"SingleInstance">
</activity>
```
2. 代码中设置
```java
Intent intent = new Inten(MainActivity.this,SecondActivity.class);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
startActivity(intent);
```
# Android Studio 项目目录结构
1. .gradle和.idea
    存放自动生成的一些文件，无需关心
2. app
    存放项目代码与资源
3. build
    包含编译时自动生成的文件
4. gradle
    包含了gradle wrapper的配置文件
5. .gitignore
    指定目录或文件排除在版本控制（git）之外的
6. build.gradle
    项目全局构建脚本，通常不需要修改
7. gradle.properties
    这个文件时全局的gradle配置文件
8. gradlew（Linux/Macos）和grealew.bat（Windows）
    用来在命令行文件中执行gradle命令的
9. HelloWorld.iml
    iml文件时IntelliJ IDEA项目都会生成的一个文件
10. local.properties
    用于指定本机中Android SDK路径
11. settings.gradle
    指定项目中所有引入模块
## app目录结构
1. build
包含编译时自动生成的文件
2. libs
存放第三方jar包（百度地图库）
3. androidTest
用来编写Android Test测试用例的，可以对项目进行一些自动化测试
4. java
毫无疑问，java目录时放置我们所有Java代码的地方
5. res
存放资源（布局、图片、字符串等）
6. AndroidManifest.xml
整个Android项目的配置文件
7. test
此处用于编写Unit Test测试用例，是对项目进行自动化测试的另一种方式
8. .gitignore
将app模块内指定目录或者文件排除在版本控制之外
9. app.iml
10. build.gradle
app模块构建脚本
11. proguard-rules.pro
指定代码混淆规则，让读者难以阅读
# Android 活动
## 添加菜单
```java
//添加菜单 重写onCreateOpitionsMenu方法
public boolen onCreateOpitionsMenu(Menu menu) {
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
}
//编辑菜单点击功能 重写onOpitionsItemSelected方法
public boolen onOpitionsItemSelected(MenuItem item) {
	switch(item.getItemId()) {
		case R.id.add_item:
			//具体操作
			break;
		default:
			super.onOpitionsItemSelected(item);
			break;
	}
	return true;//代表执行了按钮操作、其他函数检测不到此次按钮事件
}
```
## Intent (显示Intent和隐式Intent)
### 显示Intent
指定启动哪一个活动
### 隐式Intent
通过一系列更为抽象的action和category等信息，然后交由系统分析这个Intent，帮助我们找到这个活动，如果有多个合适的，则有用户去选择启动哪一个
1. Intent.ACTION_VIEW 打开浏览器
2. Intent.ACTION_DIAL 打开拨打电话界面
3. Intent.ACTION_CALL 直接拨打电话，需要权限
### 通过Intent项活动传递信息
```java
intent.putExtra(String key, String data);//保存数据
String data = getIntent().getStringExtra(String key);//获取数据
intent.putExtra(String key, int data);//保存数据
String data = getIntent().getIntExtra(String key);//获取数据

class Person extend Serializable{ }//序列话类 可以存储的类
intent.putExtra(String key, Person person);//保存数据
String data = getIntent().getSerializableExtra(String key);//获取数据

//该方式相比与Serializable实现复杂但效率高，不用序列话对象了
class Student extend Parcelable {
	private String name;
	private int age;
	//...
	@Override
	public int describeContents() {
		return 0;
	}
	@Override
	public void writeToParcel(Parcle dest, int flage) {
		desc.writeString(name);
		desc.writeInt(age);
	}
	public static final Parcelable.Creator<Student> CREATOR = new 
						Parcelable.Creator<Student> {
		@Override
		public Student createFromParcel(Parcel source) {
			Student student = new Student();
			//注意此时读取的顺序与写的顺序一致
			student.name = souce.readString();
			student.age = source.readInt();
			return student;
		}
		@Override
		public Student[] newArray(int size) {
			return new Student[size];
		}
	}
} 
intent.putExtra(String key, Student student);//保存数据
String data = getIntent().getParcelableExtra(String key);//获取数据
```
### 返回数据给上一个活动
```java
	//MainActivity
	Intent intent = new Intent(...);
	startActivityForResult(intent, 1);
	@Override
	protected void onActivityResult() {...}
	//SecondActivity
	Intent intent = new Intent();
	intent.putExtra("key", "data");
	setResult(RESULT_OK, intent);
	finish();
```
### 返回键回调函数
```java
public void onBackPressed();
```

