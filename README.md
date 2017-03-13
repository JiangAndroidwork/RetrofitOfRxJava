# RetrofitOfRxJava
RxJava+Retrofit+MVP有弹窗提示
v1.3版本针对本身公司的特性封装了返回数据的过程，只返回结果。
首先添加依赖：
在工程的build.gradle中添加
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
其次在mould的build.gradle中添加：
dependencies {
	        compile 'com.github.JiangAndroidwork:RetrofitOfRxJava:v1.3'
	}

注：本Demo针对的json格式：
{
  "code" : "1",
  "msg" : "",
  "result" : [{}]
}
步骤：
1,根据json格式利用GsonFormat插件生成基类，注意需要继承BaseReponse。BaseReponse是根据相应的
json固定格式超类。
2,根据请求参数和url编写Retrofit的service接口，如：
 @GET("getGradeExams")
 Flowable<TestBean> getRetrofitData(@Query("classId") int classId, @Query("accessToken") String accessToken);
 @GET("examGetMyInfo")
 Flowable<BaseReponse<List<GetInfo.ResultEntity>>> getExamGetMyInfo(@Query("accessToken") String accessToken);
3,实现Http请求：
ProgressBarOfRetrofit ss = ProgressBarOfRetrofit.getInstance(this,url,new RetrofitOfRxJavaCallBack() {
            @Override
            public void callBack(Retrofit retrofit) {
                retrofit.create(RetrofitMethodsInterface.class)
                        .getExamGetMyInfo("9969171b881c7f74c32558e11b86936f")
                        .delay(5, TimeUnit.SECONDS)
                        .map(new ApiFunction<List<GetInfo.ResultEntity>>())
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new ApiSubscriber<List<GetInfo.ResultEntity>>() {
                            @Override
                            protected void onError(String msg) {
                                    Log.i("出错==",msg.toString());
                            }

                            @Override
                            protected void onSuceess(List<GetInfo.ResultEntity> resultEntities) {
                                Log.i("输出结果--",resultEntities.toString());
                            }
                        });
            }
        });
     ss.setStart(false);
最后ss.setStart(false)中的参数是是否缓存请求，上面的例子是v1.3版本中对过程封装，只返回"result"的数据
注意：new ApiFunction<T>()中的类型应该和service接口RetrofitMethodsInterface.class中的返回类型一致。
