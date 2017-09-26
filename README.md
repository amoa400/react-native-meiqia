
# react-native-meiqia

## Getting started

`$ npm install react-native-meiqia --save`

### Mostly automatic installation

`$ react-native link react-native-meiqia`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-meiqia` and add `RNMeiqia.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNMeiqia.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNMeiqiaPackage;` to the imports at the top of the file
  - Add `new RNMeiqiaPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-meiqia'
  	project(':react-native-meiqia').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-meiqia/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-meiqia')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNMeiqia.sln` in `node_modules/react-native-meiqia/windows/RNMeiqia.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Meiqia.RNMeiqia;` to the usings at the top of the file
  - Add `new RNMeiqiaPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNMeiqia from 'react-native-meiqia';

// TODO: What to do with the module?
RNMeiqia;
```
  