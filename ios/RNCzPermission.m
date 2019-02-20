
#import "RNCzPermission.h"
#import <AVFoundation/AVCaptureDevice.h>

@implementation RNCzPermission

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(CheckPushNotification:(RCTResponseSenderBlock)callback)
{
  dispatch_async(dispatch_get_main_queue(), ^{
      UIUserNotificationSettings * settings = [[UIApplication sharedApplication] currentUserNotificationSettings];
      callback(@[@(settings == UIUserNotificationTypeNone ? 2 : 1)]);
  });
}

RCT_EXPORT_METHOD(OpenPushNotification:(RCTResponseSenderBlock)callback)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        NSURL * url = [NSURL URLWithString:UIApplicationOpenSettingsURLString];
        if ([[UIApplication sharedApplication] canOpenURL:url]) {
            callback(@[@(1)]);
            [[UIApplication sharedApplication] openURL:url];
        } else {
            callback(@[@(2)]);
        }
    });
}

RCT_EXPORT_METHOD(CheckNetwork:(RCTResponseSenderBlock)callback)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        
    });
}

RCT_EXPORT_METHOD(OpenNetwork:(RCTResponseSenderBlock)callback)
{
    dispatch_async(dispatch_get_main_queue(), ^{

    });
}

RCT_EXPORT_METHOD(CheckCamera:(RCTResponseSenderBlock)callback)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        AVAuthorizationStatus status = [AVCaptureDevice authorizationStatusForMediaType:AVMediaTypeVideo];
        BOOL isOpen = NO;
        if (status == AVAuthorizationStatusAuthorized) {
            isOpen = YES;
        }
        callback(@[@(isOpen ? 1 : 2), @(status + 1)]);
    });
}

RCT_EXPORT_METHOD(OpenCamera:(RCTResponseSenderBlock)callback)
{
    dispatch_async(dispatch_get_main_queue(), ^{
        NSURL * url = [NSURL URLWithString:UIApplicationOpenSettingsURLString];
        if ([[UIApplication sharedApplication] canOpenURL:url]) {
            callback(@[@(1)]);
            [[UIApplication sharedApplication] openURL:url];
        } else {
            callback(@[@(2)]);
        }
    });
}

@end
  
