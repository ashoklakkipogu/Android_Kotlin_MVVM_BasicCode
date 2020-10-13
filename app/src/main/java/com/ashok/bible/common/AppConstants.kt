package com.ashok.bible.common

import java.text.SimpleDateFormat
import java.util.*

public class AppConstants {
    companion object {
        const val FIRE_BASE_AUTH_KEY =
            "key=AAAAI4Pu460:APA91bGr_znPHeAvGI2ypdmvzSP7-xxU3lg0Ks02jNikalnmaFMSba_fGv8dZP9LBHqrkWooYQmpNTlq-TmTNfA8JtbUyWsrT1I7Kx8gCChUlHVPr9j7FpLMQYMxmD4KY7g3BknrrvBd"

        const val DATE_FORMAT_dd_MM_YYYY = "dd-MM-YYYY"
        const val DATE_FORMAT_DD_MM_YYYY = "DD-MM-YYYY"
        const val DATE_FORMAT_dd_MM_yyyy_hh_mm_a = "dd-MM-yyyy hh:mm a"

        const val DATE_FORMAT_yyyy_MM_dd_HH_mm_ss_SSS_Z = "yyyy-MM-dd'T'HH:mm:ss.SSS"
        const val EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$"
    }
}