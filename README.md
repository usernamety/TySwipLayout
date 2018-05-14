# TySwipLayout
类似微信滑动删除activity,解决由于透明activity所导致的activity之间转场退出动画无效问题，基于SwipeBackHelper源码修改，不依赖透明activity

### 使用方法
#### dependencies {
	        implementation 'com.github.usernamety:TySwipLayout:v1.0.6'
	}
### 解除windowIsTranslucent=true限制
 < item name="android:windowIsTranslucent">false</ item >
####  使用TySwipLayout，你可以将windowIsTranslucent=false，这样就不会与你的windowAnimationStyle发送冲突，从而导致你的转场动画失效
    

    
例子:
```
    在你的activity主题样式中添加动画
    
          <item name="android:windowAnimationStyle">@style/TySwipLayoutAnim</item>
          
    
  
    完整例子
    
     <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
        <item name="android:windowAnimationStyle">@style/TySwipLayoutAnim</item>
    </style>
```
