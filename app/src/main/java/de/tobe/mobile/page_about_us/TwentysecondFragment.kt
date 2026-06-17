package de.tobe.mobile.page_about_us

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import de.tobe.mobile.databinding.FragmentTwentysecondBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TwentysecondFragment : Fragment() {

    private var _binding: FragmentTwentysecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTwentysecondBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}