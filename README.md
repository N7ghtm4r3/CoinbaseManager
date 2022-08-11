# CoinbaseManager
**v1.0.6**

This is a Java Based library useful to work with Coinbase's API service.

## Implementation

Add the JitPack repository to your build file

### Gradle

- Add it in your root build.gradle at the end of repositories

```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
- Add the dependency

```gradle
dependencies {
	implementation 'com.github.N7ghtm4r3:CoinbaseManager:1.0.6'
}
```

### Maven

- Add it in your root build.gradle at the end of repositories

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
- Add the dependency

```xml
<dependency>
    <groupId>com.github.N7ghtm4r3</groupId>
    <artifactId>CoinbaseManager</artifactId>
    <version>1.0.6</version>
</dependency>
```

## 🛠 Skills
- Java

## Endpoints managers available

- Coinbase Pro Exchange

The other endpoints managers will be gradually released

## Usage/Examples

```java

// init a Coinbase manager
try {
    CoinbaseProductsManager coinbaseProductsManager = new CoinbaseProductsManager("yourApiKey", "yourSecretKey", "yourPassphrase");
} catch (Exception e) {
    e.printStackTrace();
}
```

### Responses

- String: will return response formatted as String object

```java
try {
    System.out.println(coinbaseProductsManager.getProductStats("BTC-USD"));
} catch (Exception e) {
    e.printStackTrace();
}
```

- JSON: will return response formatted as JSON (JSONObject or JSONArray)

```java
try {
    System.out.println(coinbaseProductsManager.getProductStatsJSON("BTC-USD"));
} catch (Exception e) {
    e.printStackTrace();
}
```

- Custom-object: will return response formatted as custom object provided by library

```java
try {
    System.out.println(coinbaseProductsManager.getProductStatsObject("BTC-USD"));
} catch (Exception e) {
    e.printStackTrace();
}
```

- Primitives: some requests will return primitive types like boolean, long, double

```java
// it return double type es. 1.544
try {
    System.out.println(CoinbaseManager.roundValue(1.544242, 3));
} catch (Exception e) {
    e.printStackTrace();
}
```

### Errors handling

```java
try {
    System.out.println(coinbaseProductsManager.getProductStatsJSON("BTC-USD"));
} catch (Exception e) {
    System.out.println(coinbaseProductsManager.getErrorResponse());
    //or
    coinbaseProductsManager.printErrorResponse();   
}
/* NOTE: if is not a request error will appear: "Error is not in api request, check out your code"
  and you will have to work on your code to manage error, you can also change default error message*/
```

## Authors

- [@N7ghtm4r3](https://www.github.com/N7ghtm4r3)

## Support

If you need help using the library or encounter any problems or bugs, please contact us via the following links:

- Support via <a href="mailto:infotecknobitcompany@gmail.com">email</a>
- Support via <a href="https://github.com/N7ghtm4r3/CoinbaseManager/issues/new">GitHub</a>

Thank you for your help!

## Badges

[![](https://img.shields.io/badge/Google_Play-414141?style=for-the-badge&logo=google-play&logoColor=white)](https://play.google.com/store/apps/developer?id=Tecknobit)
[![](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)](https://github.com/N7ghtm4r3/BinanceManager/blob/main/README.md)

[![Twitter](https://img.shields.io/twitter/url/https/twitter.com/cloudposse.svg?style=social&label=Tecknobit)](https://twitter.com/tecknobit)
[![](https://jitpack.io/v/N7ghtm4r3/CoinbaseManager.svg)](https://jitpack.io/#N7ghtm4r3/CoinbaseManager)

## Donations 

If you want support project and developer with crypto: **0x5f63cc6d13b16dcf39cd8083f21d50151efea60e**

![](https://img.shields.io/badge/Bitcoin-000000?style=for-the-badge&logo=bitcoin&logoColor=white) 
![](https://img.shields.io/badge/Ethereum-3C3C3D?style=for-the-badge&logo=Ethereum&logoColor=white)

If you want support project and developer with <a href="https://www.paypal.com/donate/?hosted_button_id=5QMN5UQH7LDT4">PayPal</a>


Copyright © 2022 Tecknobit
