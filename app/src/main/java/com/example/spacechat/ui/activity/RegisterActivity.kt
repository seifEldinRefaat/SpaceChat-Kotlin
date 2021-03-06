package com.example.spacechat.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.spacechat.databinding.ActivityRegisterBinding
import com.example.spacechat.model.UserModel
import com.example.spacechat.userServices.AuthWithEmailAndPassword

class RegisterActivity : AppCompatActivity() {

    private val binding: ActivityRegisterBinding by lazy {
        ActivityRegisterBinding.inflate(layoutInflater)
    }

    // init AuthWithEmailAndPassword class
    private val auth: AuthWithEmailAndPassword by lazy {
        AuthWithEmailAndPassword(this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSignUp!!.setOnClickListener {
            createNewUser()
        }

        binding.button!!.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }


    }

    private fun createNewUser() {
        auth.createUser(getDataFromUI())
    }

    private fun getDataFromUI(): UserModel {
        return UserModel().apply {
            username = binding.editTextUsername!!.text.toString().trim()
            email = binding.editTextEmail!!.text.toString().trim()
            password = binding.editTextPassword!!.text.toString().trim()
        }
    }
}