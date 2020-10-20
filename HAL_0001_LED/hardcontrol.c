#include <jni.h>
#include <stdio.h>
#include <stdlib.h>

#include <android/log.h>  /* liblog */

//__android_log_print(ANDROID_LOG_DEBUG, "JNIDemo", "native add ...");
#define LOG_TAG    "Native-Dev-LED"
#define LOGV(...)   __android_log_print(ANDROID_LOG_VERBOSE, LOG_TAG, __VA_ARGS__)
#define LOGD(...)   __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define LOGI(...)   __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define LOGW(...)   __android_log_print(ANDROID_LOG_WARN, LOG_TAG, __VA_ARGS__)
#define LOGE(...)   __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

jint ledOpen(JNIEnv *env, jobject cls)
{
    LOGI("Native : LED Open ...");

    return 0;
}

void ledClose(JNIEnv *env, jobject cls)
{
    LOGI("Native : LED Close ...");
}

jint ledCtrl(JNIEnv *env, jobject cls, jint which, jint state)
{
    LOGI("Native : LED Ctrl:%d, %d", which, state);
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

    LOGI("Native : LED JNI OnLoad");
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

