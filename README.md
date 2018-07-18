# XDialog
一个自定义底部和中间的dialog

## 1、如何使用
目前支持主流开发工具AndroidStudio的使用，直接配置build.gradle，增加依赖即可.
	
1.先在项目根目录的 build.gradle 的 repositories 添加:
```
allprojects {
	repositories {
			...
			maven { url "https://jitpack.io" }
		}
  }
```
2.然后在dependencies添加:
```
dependencies {
	...
	implementation 'com.github.chentl666:XDialog:1.0.0'
}
```
