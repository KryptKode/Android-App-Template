package com.kryptkode.flashalerts.app.utils

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import com.kryptkode.flashalerts.R
import javax.inject.Inject


/**
 * Created by kryptkode on 2/26/2020.
 */
class SendEmailUtil @Inject constructor(private val activity: AppCompatActivity) {

    fun sendEmail(
        recipientEmail: String,
        hint: String = activity.getString(R.string.send_email_hint),
        subject: String = "",
        body: String = ""
    ) {
        val intent = Intent(
            Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto", recipientEmail, null
            )
        )
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipientEmail))
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, body)
        activity.startActivity(
            Intent.createChooser(
                intent,
                hint
            )
        )
    }
}