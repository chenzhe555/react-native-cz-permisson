
# react-native-cz-permission

## Getting started

`$ npm install react-native-cz-permission --save`

### Mostly automatic installation

`$ react-native link react-native-cz-permission`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-cz-permission` and add `RNCzPermission.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNCzPermission.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.chenzhe.permission.RNCzPermissionPackage;` to the imports at the top of the file
  - Add `new RNCzPermissionPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-cz-permission'
  	project(':react-native-cz-permission').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-cz-permission/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-cz-permission')
  	```


## Usage
```javascript
import RNCzPermission from 'react-native-cz-permission';

// TODO: What to do with the module?
RNCzPermission;
```
  