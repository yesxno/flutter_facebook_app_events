package id.oddbit.flutter.facebook_app_events

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel

/** Keeps the Flutter API available on Android without loading Meta's SDK. */
class FacebookAppEventsPlugin : FlutterPlugin, MethodChannel.MethodCallHandler {
  private var channel: MethodChannel? = null

  override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(binding.binaryMessenger, "flutter.oddbit.id/facebook_app_events")
    channel?.setMethodCallHandler(this)
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    channel?.setMethodCallHandler(null)
    channel = null
  }

  override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
    when (call.method) {
      "initializeSdk",
      "activateApp",
      "clearUserData",
      "setUserData",
      "clearUserID",
      "flush",
      "getApplicationId",
      "logEvent",
      "logPushNotificationOpen",
      "setUserID",
      "setAutoLogAppEventsEnabled",
      "setDataProcessingOptions",
      "getAnonymousId",
      "logPurchase",
      "setAdvertiserTracking",
      "setAdvertiserIdCollectionEnabled",
      "setLimitEventAndDataUsage",
      "setAutoLogMetaDataEnabled",
      "setGraphApiVersion",
      "logProductItem",
      "setPushNotificationsDeviceToken", "setPushNotificationToken",
      "setFlushBehavior",
      "getFlushBehavior",
      "getUserData",
      "getUserID",
      "clearUserDataForType",
      "setDebugLoggingEnabled" -> result.success(null)
      else -> result.notImplemented()
    }
  }
}
