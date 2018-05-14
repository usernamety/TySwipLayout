使用方法:
step1:
  Add it in your root build.gradle at the end of repositories:
	
  allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 step2:
  Add the dependency
  
  dependencies {
	        implementation 'com.github.usernamety:TySwipLayout:v1.0.6'
	}
