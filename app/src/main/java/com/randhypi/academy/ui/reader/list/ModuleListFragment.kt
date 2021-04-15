package com.randhypi.academy.ui.reader.list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.randhypi.academy.R
import com.randhypi.academy.data.ModuleEntity
import com.randhypi.academy.databinding.FragmentModuleListBinding
import com.randhypi.academy.ui.reader.CourseReaderActivity
import com.randhypi.academy.ui.reader.CourseReaderCallback
import com.randhypi.academy.ui.reader.CourseReaderViewModel
import com.randhypi.academy.utils.DataDummy

class ModuleListFragment : Fragment(), ModuleListAdapter.MyAdapterClickListener {

    private lateinit var courseReaderViewModel: CourseReaderViewModel

    companion object {
        val TAG: String = ModuleListFragment::class.java.simpleName

        fun newInstance(): ModuleListFragment = ModuleListFragment()
    }

    private lateinit var fragmentModuleListBinding: FragmentModuleListBinding
    private lateinit var adapter: ModuleListAdapter
    private lateinit var courseReaderCallback: CourseReaderCallback

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        fragmentModuleListBinding = FragmentModuleListBinding.inflate(inflater, container, false)
        return fragmentModuleListBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        courseReaderViewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[CourseReaderViewModel::class.java]
        adapter = ModuleListAdapter(this)
        populateRecyclerView(courseReaderViewModel.getModules())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        courseReaderCallback = context as CourseReaderActivity
    }

    override fun onItemClicked(position: Int, moduleId: String) {
        courseReaderCallback.moveTo(position, moduleId)
        courseReaderViewModel.setSelectedModule(moduleId)
    }

    private fun populateRecyclerView(modules: List<ModuleEntity>) {
        with(fragmentModuleListBinding) {
            progressBar.visibility = View.GONE
            adapter.setModules(modules)
            rvModule.layoutManager = LinearLayoutManager(context)
            rvModule.setHasFixedSize(true)
            rvModule.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            rvModule.addItemDecoration(dividerItemDecoration)
        }
    }
}