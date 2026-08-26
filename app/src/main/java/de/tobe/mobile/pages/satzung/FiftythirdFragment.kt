package de.tobe.mobile.pages.satzung

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.tobe.mobile.databinding.FragmentFiftythirdBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FiftythirdFragment : Fragment() {

    private var _binding: FragmentFiftythirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFiftythirdBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}