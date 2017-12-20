# bmobLibrary
##引入
<p>在项目的build.gradle中添加如下代码</p>
<pre>
  <code>
    allprojects{
      repositories {
          jcenter()
          maven { url "https://jitpack.io" }
      }
    }
  </code>
</pre>

<p>在Module的build.gradle中添加如下代码</p>
<pre>
  <code>
    compile 'com.github.xinruzhou:bmobLibrary:1.0.7'
  </code>
</pre>

##使用
<p>1.复制<a href="https://github.com/xinruzhou/bmobLibrary/blob/master/keys/" title="">签名文件</a>、<a href="https://github.com/xinruzhou/bmobLibrary/blob/master/gradle/common_gradle.gradle" title="">common.gradle</a>、<a href="https://github.com/xinruzhou/bmobLibrary/blob/master/gradle/global.gradle" title="">global.gradle</a>和<a href="https://github.com/xinruzhou/bmobLibrary/blob/master/gradle/flavors.gradle" title="">flavors.gradle</a>到项目的gradle文件夹中</p>
<p>2.修改Module的build.gradle</p>
<pre>
  <code>
    apply from: '../gradle/common_gradle.gradle'
    dependencies {
        compile fileTree(include: ['*.jar'], dir: 'libs')
        compile 'com.github.xinruzhou:bmobLibrary:1.0.7'
    }
  </code>
</pre>
<p>3.在项目的Application中添加代码</p>
<pre>
  <code>
    @Override
    public void onCreate() {
        super.onCreate();
        //BuildConfig.BMOB_KEY是根据global.gradle中配置的bmobkey自动生成的
        Library.init(this, BuildConfig.BMOB_KEY.gradle, BuildConfig.DEBUG);
    }
  </code>
</pre>
<p>4.新建SplashActivity继承SplashBaseActivity,并复写以下方法</p>
<pre>
  <code>
    public class SplashActivity extends SplashBaseActivity{
        @Override
        protected void toMain() {
            //需要跳转到主界面
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }

        @Override
        protected int getSplashImageRes() {
            //配置启动图，BuildConfig.SPLASH_PIC是根据global.gradle中配置的启动图自动生成的
            return ResourceUtil.getDrawableId(this, BuildConfig.SPLASH_PIC);
        }
    }
  </code>
</pre>
<p>5.配置AndroidManifest.xml</p>
<pre>
  <code>
        //配置应用的图标
       android:icon="@mipmap/你的logo图"
       //将你的SplashActivity配置为启动Activity
  </code>
</pre>
<p>6.删除string.xml中的app_name和colors.xml中的colorPrimary</p>
<p>7.编译运行</p>
