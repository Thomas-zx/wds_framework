#include <jni.h>
#include <stdio.h>
#include <stdlib.h>

//#include <android/log.h>  /* liblog */

jint ledOpen(JNIEnv *env, jobject cls)
{
    printf("ledOpen\n");
    return 0;
}

void ledClose(JNIEnv *env, jobject cls)
{
    printf("ledClose\n");
}

jint ledCtrl(JNIEnv *env, jobject cls, jint which, jint state)
{
    printf("ledCtrl\n");
    return 0;
}

static const JNINativeMethod methods[] = {
    {"ledOpen", "()I", (void *)ledOpen},
    {"ledClose", "()V", (void *)ledClose},
    {"ledCtrl", "(II)I", (void *)ledCtrl},
};

/* System.loadLibrary */
JNIEXPORT jint JNICALL
JNI_OnLoad(JavaVM* jvm, void* reserved)
{
    JNIEnv *env;
    jclass cls;

    if ((*jvm)->GetEnv(jvm, (void **)&env, JNI_VERSION_1_4)) {
    	return JNI_ERR; /* JNI version not supported */
    }

    cls = (*env)->FindClass(env, "com/example/hardwarelibrary/HardControl");
    if (cls == NULL) {
    	return JNI_ERR;
    }

    /* 2. map java hello <-->c c_hello */
    if ((*env)->RegisterNatives(env, cls, methods, sizeof(methods)/sizeof(methods[0])) < 0)
    	return JNI_ERR;
    
    return JNI_VERSION_1_4;
}
