package de.tobe.mobile.page_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.tobe.mobile.databinding.FragmentTwelvthBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TwelvthFragment : Fragment() {

    private var _binding: FragmentTwelvthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTwelvthBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}