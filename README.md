# native-property-issue

This repository showcases a property binding issue in spring boot. It is not possible to configure a media type via
config properties in a way that works for (classic) jvm and (graalvm) native builds. This setup gives an example for a
standard spring property (`spring.data.rest.default-media-type`) and a custom configuration property.

For further information see [spring-projects/spring-boot#35410](https://github.com/spring-projects/spring-boot/issues/35410)

## steps to reproduce

### Case 1

 - Apply the media type configuration with a slash `/` in application.properties (default).
 - Start the application with `./gradlew bootRun` and the
 - Result: the application starts without an issue


### Case 2

 - Apply the media type configuration with a slash `/` in application.properties (default).
 - Start the application with `./gradlew nativeRun` and the
 - Result: the application does not start because of property binding error:

```
***************************
APPLICATION FAILED TO START
***************************

Description:

Failed to bind properties under 'foo.media-type' to org.springframework.http.MediaType:

    Property: foo.media-type
    Value: "application/json"
    Origin: class path resource [application.properties] - 3:16
    Reason: failed to convert java.lang.String to org.springframework.http.MediaType (caused by java.lang.IllegalArgumentException: Invalid token character '/' in token "application/json")

Action:

Update your application's configuration
```


### Case 3

 - Apply the media type configuration with a dash `-` in application.properties (comment the upper block, uncomment the lower block).
 - Start the application with `./gradlew nativeRun` and the
 - Result: the application starts without an issue


### Case 4

 - Apply the media type configuration with a dash `-` in application.properties (comment the upper block, uncomment the lower block).
 - Start the application with `./gradlew bootRun` and the
 - Result: the application does not start because of property binding error:

```
***************************
APPLICATION FAILED TO START
***************************

Description:

Failed to bind properties under 'foo.media-type' to org.springframework.http.MediaType:

    Property: foo.media-type
    Value: "application-json"
    Origin: class path resource [application.properties] - 7:16
    Reason: failed to convert java.lang.String to org.springframework.http.MediaType (caused by org.springframework.util.InvalidMimeTypeException: Invalid mime type "application-json": does not contain '/')

Action:

Update your application's configuration
```

### error matrix

| build type         | jvm (`bootRun`) | native (`nativeRun`) |
|--------------------|-----------------|----------------------|
| `application/json` | ✅ works         | ❌ binding issue      |
| `application-json` | ❌ binding issue | ✅ works              |


## unit tests

The repository contains a single unit test, to verify the correct media type is set.
