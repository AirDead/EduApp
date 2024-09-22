package dev.airdead.eduapp.ext

import android.util.Log

inline fun info(message: () -> String) {
    Log.i("EduApp", message())
}

inline fun debug(message: () -> String) {
    Log.d("EduApp", message())
}

inline fun error(message: () -> String) {
    Log.e("EduApp", message())
}

inline fun warn(message: () -> String) {
    Log.w("EduApp", message())
}

inline fun verbose(message: () -> String) {
    Log.v("EduApp", message())
}

inline fun assert(message: () -> String) {
    Log.wtf("EduApp", message())
}