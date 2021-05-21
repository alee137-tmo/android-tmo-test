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
import com.example.android.tmo.test.databinding.AlphaFragmentBinding
import com.example.android.tmo.test.databinding.BetaFragmentBinding
import com.example.android.tmo.test.viewmodel.AlphaViewModel

/**
 * Create a fragment that has buttons that go to Beta Fragment and Gamma Fragment.
 */
class AlphaFragment : Fragment() {

    companion object {
        fun newInstance() = AlphaFragment()
    }

    private lateinit var viewModel: AlphaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<AlphaFragmentBinding>(inflater,R.layout.alpha_fragment, container, false)

        val navHost = childFragmentManager.findFragmentById(R.id.alphaFragment) as NavHostFragment
        val navController = navHost.navController

        binding.navToBeta.setOnClickListener {
            navController.navigate(R.id.action_alphaFragment_to_betaFragment)
        }

        binding.navToGamma.setOnClickListener {

            navController.navigate(R.id.action_alphaFragment_to_gammaFragment)

        }



        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlphaViewModel::class.java)
        // TODO: Use the ViewModel

    }

}