//
//  HBDNavigationController.h
//  NavigationHybrid
//
//  Created by Listen on 2017/12/16.
//  Copyright © 2018年 Listen. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface HBDNavigationController : UINavigationController

- (void)updateNavigationBarAlpha:(float)alpha;

- (void)updateNavigationBarShadowImageAlpha:(float)alpha;

- (void)hideNavigationBarShadowImageIfNeededForViewController:(UIViewController *)vc;

@end
