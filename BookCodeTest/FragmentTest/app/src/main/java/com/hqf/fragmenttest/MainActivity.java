package com.hqf.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hqf.fragmenttest.R;
import com.hqf.fragmenttest.base.AnotherRightFragment;
import com.hqf.fragmenttest.base.RightFragment;

/*
* 动态添加碎片
* 1. 创建待添加的碎片
* 2. 获取FragmentManager，在活动中可以直接调用getSupportFragmentManager()方法得到
* 3. 开启一个事务，通过调用beginTransaction()方法开启
* 4. 相容器内添加或替换碎片，一般使用replace()方法实现，需要传入容器id和待添加的碎片实例
* 5. 提交事务，调用commit()方法来完成*/
/*
* 限定符
* 1. small 提供给小屏幕设备的资源
* 2. normal 中等屏幕设备
* 3. large 大屏幕设备
* 4. xlarge 超大屏幕设备
* 5. ldpi 120dpi一下
* 6. mdpi 120dpi~160dpi
* 7. hdpi 160dpi~240dpi
* 8. xhdpi 240dpi~320dpi
* 9. xxhdpi 320dpi~480dpi
* 10.land 横屏
* 11. 竖屏
 */
public class MainActivity extends AppCompatActivityBase implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(this);
//        replaceFragment(new RightFragment());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
//        FragmentManager fragmentManager =  getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();//开启一个事务
//        transaction.replace(R.id.right_layout, fragment);//想容器内添加碎片
//        transaction.addToBackStack(null);
//        transaction.commit();//提交事务
    }
}
