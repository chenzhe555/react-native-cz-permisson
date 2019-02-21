
## Manual installation

npm install react-native-cz-permission --save

	

## Usage
###  1.引入组件
```
import Permission from "react-native-cz-permission";
```

iOS: 在Podfile中加入
```
pod 'RNCzPermission', :path => '../node_modules/react-native-cz-permission/ios/RNCzPermission.podspec'
```
然后执行
```
pod install
```

###  2.属性:
###  3.属性方法:
###  4.供外部调用的方法:
```
/*
* 检验是否开启通知
* callback(result) result: 1.是, 2否
* */
Permission.checkPushNotification((result) => {
        
});
```

```
/*
* 打开通知设置页面
* callback(result) result: 1.可打开 2.不可打开
* */
Permission.openPushNotification((result) => {
        
});
```

```
/*
* 检验是否开启网络
* callback(result) result: 1.是, 2否
* */
Permission.checkNetwork((result) => {
        
});
```

```
/*
* 打开网络设置页面
* callback(result) result: 1.是, 2否
* */
Permission.openNetwork((result) => {
        
});
```

```
/*
* 检验是否开启相机
* callback(result, type) result: 1.是, 2否; type: 1.未弹出授权页 2.该App不能使用相机 3.用户拒绝访问相机 4.用户允许访问相机
* */
Permission.checkCamera((result) => {
        
});
```

```
/*
* 打开相机设置页面
* callback(result) result: 1.是, 2否
* */
Permission.openCamera((result) => {
        
});
```
