#!/bin/sh
arm-cortex_a9-linux-gnueabi-gcc -fPIC -nostdlib -shared hardcontrol.c -o libhardcontrol.so -I/home/zhangxing/tools/jdk1.7.0_51/include/ -I/home/zhangxing/tools/jdk1.7.0_51/include/linux
cp libhardcontrol.so /home/zhangxing/project/Android/AndroidStudioProjects/MyApplication/app/libs/armeabi/
