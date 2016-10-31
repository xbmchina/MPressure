#include <jni.h>
#include <stdlib.h>
//模拟产生压力数据。
int getPressure(){
	return rand()%100;
}
int flag = 0;
JNIEXPORT void JNICALL Java_com_zero_mp_MainActivity_startMoniter
  (JNIEnv * env, jobject obj){
	flag = 1;
	while(flag){
		//①拿到字节码对象
		sleep(1);
			jclass clazz =(*env)->FindClass(env,"com/zero/mp/MainActivity");
			jmethodID methodID = (*env)->GetMethodID(env,clazz,"setPressure","(I)V");//拿到方法ID
			(*env)->CallVoidMethod(env,obj,methodID,getPressure());//C语言回调Java代码
	}

}

/*
 * Class:     com_itheima_pressuredemo_MainActivity
 * Method:    stopMoniter
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_zero_mp_MainActivity_stopMoniter
  (JNIEnv * env, jobject obj){
	flag = 0;
}
