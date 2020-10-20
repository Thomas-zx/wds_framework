#!/bin/sh
#/home/zhangxing/sata/Sandisk2/project/Android/OK6818/OKxx18-source-android51/prebuilts/gcc/linux-x86/arm/arm-linux-androideabi-4.8/bin/arm-linux-androideabi-gcc
arm-linux-androideabi-gcc -fPIC -nostdlib -shared hardcontrol.c -o libhardcontrol.so \
    -I/home/zhangxing/tools/jdk1.7.0_51/include/ \
    -I/home/zhangxing/tools/jdk1.7.0_51/include/linux \
    -I/home/zhangxing/sata/Sandisk2/project/Android/OK6818/OKxx18-source-android51/prebuilts/ndk/9/platforms/android-19/arch-arm/usr/include \
    -L/home/zhangxing/sata/Sandisk2/project/Android/OK6818/OKxx18-source-android51/prebuilts/ndk/9/platforms/android-19/arch-arm/usr/lib \
    /home/zhangxing/sata/Sandisk2/project/Android/OK6818/OKxx18-source-android51/prebuilts/ndk/9/platforms/android-19/arch-arm/usr/lib/libc.so \
    /home/zhangxing/sata/Sandisk2/project/Android/OK6818/OKxx18-source-android51/prebuilts/ndk/9/platforms/android-19/arch-arm/usr/lib/liblog.so \

cp libhardcontrol.so /home/zhangxing/project/Android/AndroidStudioProjects/MyApplication/app/libs/armeabi-v7a/
