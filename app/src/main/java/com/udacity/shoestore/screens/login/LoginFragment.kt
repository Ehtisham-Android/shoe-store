package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment()  {

    lateinit var binding: FragmentLoginBinding
    lateinit var viewModel : LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        binding.btnLogin.setOnClickListener {
            goToWelcomeScreen()
        }

        binding.btnLoginWithExistingAccount.setOnClickListener {
            goToWelcomeScreen()
        }

        return binding.root
    }

    private fun goToWelcomeScreen(){
        Navigation.findNavController(this.requireView()).navigate(R.id.action_loginFragment_to_welcomeFragment)
    }
}