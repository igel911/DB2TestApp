package com.db2testapp.presentation

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class DatePickerFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val listener =
            try {
                activity as DatePickerDialog.OnDateSetListener
            } catch (e: Exception) {
                throw IllegalStateException(
                    "${activity.toString()} must implement DatePickerDialog.OnDateSetListener"
                )
            }

        return DatePickerDialog(requireContext(), listener, 2015, 0, 1)
    }
}
