package com.example.firestore_android_application

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firestore_android_application.databinding.FragmentFirestoreBinding
import com.google.firebase.firestore.FirebaseFirestore


class FirestoreFragment : Fragment() {

    private var _binding: FragmentFirestoreBinding? = null
    private val binding get() = _binding!!
    var db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirestoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSubmit.setOnClickListener {
            val firstName = binding.txtFirstName.text.toString()
            val lastName = binding.txtLastName.text.toString()
            val age = binding.txtAge.text.toString()

            var user = mapOf("firstName" to firstName, "lastName" to lastName, "age" to age)
            db.collection("users").add(user)

            binding.txtFirstName.setText("")
            binding.txtLastName.setText("")
            binding.txtAge.setText("")

        }
    }


}