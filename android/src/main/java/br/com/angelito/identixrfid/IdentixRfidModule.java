package br.com.angelito.identixrfid;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class IdentixRfidModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    private final static String TAG = "IdentixRfidModule";
    // React
    private final ReactApplicationContext reactContext;

    // Device info
    private static final String INFO_BATTERY = "BATTERY";
    private static final String INFO_TEMPERATURE = "TEMPERATURE";
    private static final String INFO_VERSION = "VERSION";

    // RFID
    private RFIDWithUHFBluetooth uhf = RFIDWithUHFBluetooth.getInstance();

    // Bluetooth
    private BluetoothAdapter mBtAdapter = null;
    private BluetoothDevice mDevice = null;
    private BTStatus btStatus = new BTStatus();

    // Bluetooth connection
    private boolean mIsActiveDisconnect = true;
    private static final int RECONNECT_NUM = 3;
    private int mReConnectCount = RECONNECT_NUM;

    public IdentixRfidModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        reactContext.addLifecycleEventListener(this);
        mBtAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    @NonNull
    @Override
    public String getName() {
        return "RNIdentixRfid";
    }

    @Override
    public void onHostResume() {
    }

    @Override
    public void onHostPause() {
    }

    @Override
    public void onHostDestroy() {
        uhf.free();
    }

    @ReactMethod
    public void sampleMethod(String stringArgument, int numberArgument, Callback callback) {
        // TODO: Implement some actually useful functionality
        callback.invoke("Received numberArgument: " + numberArgument + " stringArgument: " + stringArgument);
    }
}
