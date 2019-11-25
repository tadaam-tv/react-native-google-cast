package com.reactnative.googlecast;

import android.graphics.Color;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReadableMap;

import java.util.Map;

public class ReadableMapUtils {
    public static @Nullable String getString(@NonNull ReadableMap map, @NonNull String key) {
        if (!map.hasKey(key)) {
            return null;
        }
        try {
            return map.getString(key);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static @Nullable ReadableMap getReadableMap(@NonNull ReadableMap map, @NonNull String key) {
        if (!map.hasKey(key)) {
            return null;
        }
        try {
            return map.getMap(key);
        } catch (Exception ignore) {
            return null;
        }
    }

    public static @Nullable Map<?, ?> getMap(@NonNull ReadableMap map, @NonNull String key) {
        ReadableMap innerMap = getReadableMap(map, key);
        if (innerMap == null) {
            return null;
        }
        try {
            return innerMap.toHashMap();
        } catch (Exception ignore) {
            return null;
        }
    }

    public static @Nullable Integer getInt(@NonNull ReadableMap map, @NonNull String key) {
        if (!map.hasKey(key)) {
            return null;
        }

        try {
            return map.getInt(key);
        }
        catch (Exception ignore) {
            return null;
        }
    }

    public static @Nullable Double getDouble(@NonNull ReadableMap map, @NonNull String key) {
        if (!map.hasKey(key)) {
            return null;
        }
        try {
            return map.getDouble(key);
        }
        catch (Exception ignore) {
            return null;
        }
    }

    public static @Nullable Float getFloat(@NonNull ReadableMap map, @NonNull String key) {
        Double value = getDouble(map, key);
        return value == null ? null : value.floatValue();
    }

    public static @Nullable Boolean getBoolean(@NonNull ReadableMap map, @NonNull String key) {
        if (!map.hasKey(key)) {
            return null;
        }
        try {
            return map.getBoolean(key);
        }
        catch (Exception ignore) {
            return null;
        }
    }

    public static @Nullable Integer getColor(@NonNull ReadableMap map, @NonNull String key) {
        String colorString = getString(map, key);
        if (colorString == null) {
            return null;
        }
        try {
            return Color.parseColor(colorString);
        }
        catch (Exception ignore) {
            return null;
        }
    }
}