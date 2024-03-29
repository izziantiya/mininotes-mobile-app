package com.izziantiya.mininotes.view

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.izziantiya.mininotes.R
import com.izziantiya.mininotes.databinding.ActivityMainBinding
import com.izziantiya.mininotes.view.utils.viewBinding

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.mainMtb)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener(this)

        checkPermissions()
    }

    fun setToolbarTitle(title: String) = with(binding) {
        mainMtb.title = title.uppercase()
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        supportActionBar?.setDisplayHomeAsUpEnabled(destination.id != R.id.homeFragment)
    }

    private fun checkPermissions() {
        val permissionToWrite = android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        val privileges = ActivityCompat.checkSelfPermission(
            this,
            permissionToWrite
        )
        if (privileges != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(permissionToWrite),
                1
            )
        }
    }

}