import { NativeModules } from 'react-native';
const { RNCzPermission } = NativeModules;

export default class CZPermission {
    /*
    * 检验是否开启通知
    * callback(result) result: 1.是, 2否
    * */
    static checkPushNotification = (callback) => {
        RNCzPermission.CheckPushNotification( (result) => {
            callback(result);
        });
    }

    /*
    * 打开通知设置页面
    * callback(result) result: 1.可打开 2.不可打开
    * */
    static openPushNotification = (callback) => {
        RNCzPermission.OpenPushNotification( (result) => {
            callback(result);
        });
    }


    /*
    * 检验是否开启网络
    * callback(result) result: 1.是, 2否
    * */
    static checkNetwork = (callback) => {
        RNCzPermission.CheckNetwork( (result) => {
            callback(result);
        });
    }

    /*
    * 打开网络设置页面
    * callback(result) result: 1.是, 2否
    * */
    static openNetwork = (callback) => {
        RNCzPermission.OpenNetwork( (result) => {
            callback(result);
        });
    }


    /*
    * 检验是否开启相机
    * callback(result, type) result: 1.是, 2否; type: 1.未弹出授权页 2.该App不能使用相机 3.用户拒绝访问相机 4.用户允许访问相机
    * */
    static checkCamera = (callback) => {
        RNCzPermission.CheckCamera( (result) => {
            callback(result);
        });
    }

    /*
    * 打开相机设置页面
    * callback(result) result: 1.是, 2否
    * */
    static openCamera = (callback) => {
        RNCzPermission.OpenCamera( (result) => {
            callback(result);
        });
    }
};
