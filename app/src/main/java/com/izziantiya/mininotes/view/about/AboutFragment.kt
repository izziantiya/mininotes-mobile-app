package com.izziantiya.mininotes.view.about

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.fragment.findNavController
import com.izziantiya.mininotes.BuildConfig
import com.izziantiya.mininotes.R
import com.izziantiya.mininotes.databinding.FragmentAboutBinding
import com.izziantiya.mininotes.view.about.FeedbackDialog.Companion.FEEDBACK_DIALOG_TAG
import com.izziantiya.mininotes.view.utils.BaseFragment
import com.izziantiya.mininotes.view.utils.showSingle
import com.izziantiya.mininotes.view.utils.viewBinding

class AboutFragment : BaseFragment(R.layout.fragment_about) {

    private val binding: FragmentAboutBinding by viewBinding(FragmentAboutBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        binding.apply {
            versionTv.text = BuildConfig.VERSION_NAME
            feedbackTv.setOnClickListener {
                FeedbackDialog().showSingle(childFragmentManager, FEEDBACK_DIALOG_TAG)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        findNavController().popBackStack()
        return super.onOptionsItemSelected(item)
    }
}