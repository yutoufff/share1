 package com.example.junk.android_application_23;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.junk.android_application_23.fragment.FindFragment;
import com.example.junk.android_application_23.fragment.MainFragment;
import com.example.junk.android_application_23.fragment.MeFragment;

 public class MainActivity extends AppCompatActivity implements View.OnClickListener{
     protected LinearLayout mMenuMain;
     protected LinearLayout mMenuFind;
     protected LinearLayout mMenuMe;
    protected MainFragment mMainFragment =new MainFragment();  //首页
     protected FindFragment mFindFragment=new FindFragment();  //发现
     protected MeFragment mMeFragment=new MeFragment();        //我的
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        //获取fragment管理类
        this.getSupportFragmentManager()
                .beginTransaction()
            .add(R.id.container_content,mMainFragment)
                .add(R.id.container_content,mFindFragment)
                .hide(mFindFragment)
                .add(R.id.container_content,mMeFragment)
                .hide(mMeFragment)


        //事务添加 默认：显示首页 其他页面：隐藏
        //提交
        .commit();
    }
     /**
      * 初始化视图
      */
     private void initView() {
         mMenuMain= (LinearLayout) this.findViewById(R.id.menu_main);
         mMenuFind= (LinearLayout) this.findViewById(R.id.menu_find);
         mMenuMe= (LinearLayout) this.findViewById(R.id.menu_me);

        mMenuMain.setOnClickListener(this);
        mMenuFind.setOnClickListener(this);
        mMenuMe.setOnClickListener(this);

     }


     @Override
     public void onClick(View view) {
         switch (view.getId()){
             case R.id.menu_main:
                 this.getSupportFragmentManager()
                         .beginTransaction()
                         .show(mMainFragment)
                         .hide(mFindFragment)
                         .hide(mMeFragment)
                         .commit();
                 break;
             case R.id.menu_find:
                 this.getSupportFragmentManager()
                         .beginTransaction()
                         .hide(mMainFragment)
                         .show(mFindFragment)
                         .hide(mMeFragment)
                         .commit();
                 break;
             case R.id.menu_me:
                 this.getSupportFragmentManager()
                         .beginTransaction()
                         .hide(mMainFragment)
                         .hide(mFindFragment)
                         .show(mMeFragment)
                         .commit();
                 break;
         }
     }
 }
