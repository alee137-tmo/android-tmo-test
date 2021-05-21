package com.example.android.tmo.test.fragment

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.android.tmo.test.R
import com.example.android.tmo.test.databinding.GammaFragmentBinding
import com.example.android.tmo.test.viewmodel.GammaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Create a fragment that has a button that makes an API call to get cat facts. Display them.
 */
class GammaFragment : Fragment() {

    companion object {
        fun newInstance() = GammaFragment()
    }

    private lateinit var binding: GammaFragmentBinding
    private lateinit var viewModel: GammaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate<GammaFragmentBinding>(inflater,R.layout.gamma_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GammaViewModel::class.java)
        // TODO: Use the ViewModel

        binding.getFacts.setOnClickListener {

            //Call Facts api
            GlobalScope.launch(Dispatchers.Main){


               val response =  withContext(Dispatchers.IO){
                    viewModel.getFacts()
                }

                response?.let{
                    it.forEach { item ->
                    binding.factContent.text = "${item.type }\n ${item.user} \n ${item.text} \n\n"
                }

                }


            }


        }
    }

}