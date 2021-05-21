package com.example.android.tmo.test.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.android.tmo.test.R
import com.example.android.tmo.test.databinding.BetaFragmentBinding
import com.example.android.tmo.test.viewmodel.BetaViewModel

/**
 * Create a fragment that has a button that go to Gamma Fragment.
 */
class BetaFragment : Fragment() {

    companion object {
        fun newInstance() = BetaFragment()
    }

    private lateinit var viewModel: BetaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = DataBindingUtil.inflate<BetaFragmentBinding>(inflater,R.layout.beta_fragment, container, false)
        val navHost = childFragmentManager.findFragmentById(R.id.betaFragment) as NavHostFragment
        val navController = navHost.navController

        binding.navToGamma.setOnClickListener {
            navController.navigate(R.id.action_betaFragment_to_gammaFragment)
        }



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BetaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}