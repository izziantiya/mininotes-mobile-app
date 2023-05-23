package com.izziantiya.mininotes.view.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.izziantiya.mininotes.R
import com.izziantiya.mininotes.databinding.DialogFeedbackBinding
import com.izziantiya.mininotes.view.utils.composeEmail
import com.izziantiya.mininotes.view.utils.openLink
import com.izziantiya.mininotes.view.utils.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FeedbackDialog : BottomSheetDialogFragment() {

    private val binding: DialogFeedbackBinding by viewBinding(DialogFeedbackBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.AppTheme_BottomDialog)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            cancelTv.setOnClickListener { dismiss() }

            githubBtn.setOnClickListener {
                activity?.openLink(GITHUB_ISSUE_LINK)
            }
            emailBtn.setOnClickListener {
                activity?.composeEmail()
            }
        }
    }

    companion object {
        const val FEEDBACK_DIALOG_TAG = "feedback"
        private const val GITHUB_ISSUE_LINK = "https://github.com/izziantiya/mobile-app-mininotes"
    }
}