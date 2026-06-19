package de.tobe.mobile.pages.about_us

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.tobe.mobile.databinding.FragmentTwentysixthBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TwentysixthFragment : Fragment() {

    private var _binding: FragmentTwentysixthBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTwentysixthBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}